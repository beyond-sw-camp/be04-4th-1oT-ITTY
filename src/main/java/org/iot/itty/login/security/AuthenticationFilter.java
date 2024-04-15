package org.iot.itty.login.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.iot.itty.dto.UserDTO;
import org.iot.itty.login.exception.InputNotFoundException;
import org.iot.itty.login.jwt.JwtUtil;
import org.iot.itty.login.redis.RefreshToken;
import org.iot.itty.login.redis.TokenRepository;
import org.iot.itty.login.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iot.itty.login.vo.RequestLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final LoginService loginService;
	private final Environment environment;
	private final JwtUtil jwtUtil;
	private final long accessTokenExpTime;
	private final long refreshTokenExpTime;
	private final TokenRepository tokenRepository;
	private final RedisTemplate<String, String> redisTemplate;

	public AuthenticationFilter(AuthenticationManager authenticationManager,
								LoginService loginService,
								Environment environment,
								JwtUtil jwtUtil,
		@Value("${token.expiration_time}") long accessTokenExpTime,
		@Value("${spring.data.redis.expiration_time}") long refreshTokenExpTime,
		TokenRepository tokenRepository,
		RedisTemplate<String, String> redisTemplate) {
		super(authenticationManager);
		this.loginService = loginService;
		this.environment = environment;
		this.jwtUtil = jwtUtil;
		this.accessTokenExpTime = accessTokenExpTime;
		this.refreshTokenExpTime = refreshTokenExpTime;
		this.tokenRepository = tokenRepository;
		this.redisTemplate = redisTemplate;
	}

	/* 사용자 인증 시도 시 동작 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
		AuthenticationException {

		try {
			RequestLogin requestLogin =
				new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);

			log.info("로그인 시도. 아이디: " + requestLogin.getUserEmail()
				+ "비밀번호: " + requestLogin.getUserPassword());

			/* 이메일, 비밀번호를 담은 인증 객체(authenticationToken) 생성 */
			UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(requestLogin.getUserEmail(), requestLogin.getUserPassword(), new ArrayList<>());

			return getAuthenticationManager().authenticate(authenticationToken);
		} catch (IOException e) {
			throw new InputNotFoundException();
		}
	}

	/* 사용자 인증 성공(로그인 시 입력한 정보가 DB와 일치) 시 토큰 생성 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {

		String userName = ((User)authResult.getPrincipal()).getUsername();	// 로그인한 유저의 아이디(이메일) 저장
		log.info("userName: " + userName);

		/* 입력한 email을 가진 유저가 있는지 확인하여 해당 유저 정보를 userDTO에 담아옴 */
		UserDTO userDetails = loginService.getUserDetailsByUserEmail(userName);

		/* 토큰 만료시간 계산용 */
		long now = (new Date()).getTime();

		/* 회원 권한 리스트 */
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");

		/* 유저이메일을 subject로 갖는 클레임 생성, 권한(리스트) 추가 */
		Claims claims = Jwts.claims().setSubject(userDetails.getUserEmail());
		claims.put("auth", roles.stream().filter(role -> role.equals("ROLE_USER")).collect(Collectors.toList()));

		TokenGenerator tokenGeneratorClass = new TokenGenerator(loginService, environment, jwtUtil);

		/* 액세스 토큰 생성 */
		String accessToken = tokenGeneratorClass.createAccessToken(claims, userDetails, authResult, accessTokenExpTime);

		/* 리프레시 토큰 생성 */
		String refreshToken = tokenGeneratorClass.createRefreshToken(userDetails, refreshTokenExpTime, environment);

		/* 헤더에 값 추가 */
		response.addHeader("Access-Token", accessToken);
		response.addHeader("User-Code-Pk", String.valueOf(userDetails.getUserCodePk()));
		response.addHeader("User-Email", userDetails.getUserEmail());
		response.addHeader("Refresh-Token", refreshToken);

		/* 리프레시 토큰 RedisRepository에 저장 */
		RefreshToken newRefreshToken = new RefreshToken(refreshToken, userDetails.getUserEmail(), accessToken);
		tokenRepository.save(newRefreshToken);

		/* RedisTemplate을 사용하여 저장하는 방식 */
		// ListOperations<String, String> listOperations = redisTemplate.opsForList();
		// listOperations.leftPush(String.valueOf(userDetails.getUserEmail()), refreshToken);
	}
}
