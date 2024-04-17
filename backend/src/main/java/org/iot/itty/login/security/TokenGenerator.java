package org.iot.itty.login.security;

import java.util.Date;
import java.util.stream.Collectors;

import org.iot.itty.dto.UserDTO;
import org.iot.itty.login.jwt.JwtUtil;
import org.iot.itty.login.service.LoginService;
import org.iot.itty.login.vo.ResponseToken;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenGenerator {

	private final LoginService loginService;
	private final Environment environment;
	private final JwtUtil jwtUtil;
	Date now;


	public TokenGenerator(LoginService loginService,
		Environment environment,
		JwtUtil jwtUtil) {
		this.loginService = loginService;
		this.environment = environment;
		this.jwtUtil = jwtUtil;
	}

	/* 액세스 토큰 발급 */
	/* 액세스 토큰에 저장되는 정보: claims(userCode, userEmail, 권한 정보), 토큰 발행 시간, 토큰 만료 시간 */
	public String createAccessToken(Claims claims, UserDTO userDetails, Authentication authResult,
		long accessTokenExpTime) {

		/* claims에 유저 정보(유저 코드, 이메일) 저장 */
		claims.put("userCode", userDetails.getUserCodePk());
		claims.put("userEmail", userDetails.getUserEmail());

		/* 현재 시간 정보 저장 */
		now = new Date();

		/* 이메일을 조회하여 해당 유저의 사용자의 인증(principal) 이름을 반환 */
		UserDTO userDTO = loginService.searchUserEmail(authResult.getName());

		String accessToken;
		accessToken = Jwts.builder()
			.setClaims(claims)	// user 정보 저장
			.setIssuedAt(now)	// 토큰 발행 시간 정보
			.setExpiration(new Date(now.getTime() + accessTokenExpTime))	// 토큰 만료 시간 설정
			.setSubject(authResult.getName())
			.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
			.compact();

		return accessToken;
	}

	/* 리프레시 토큰 발급 */
	/* 리프레시 토큰에 저장되는 정보: userEmail, 만료 시간 */
	public String createRefreshToken(UserDTO userDetails, long refreshTokenExpTime, Environment environment) {

		long now = (new Date()).getTime();

		Claims claims = Jwts.claims().setSubject(userDetails.getUserEmail());

		String refreshToken;
		refreshToken = Jwts.builder()
			.setClaims(claims)
			.setExpiration(new Date(now + refreshTokenExpTime))
			.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
			.compact();

		return refreshToken;
	}

	/* 리프레시 토큰으로 액세스 토큰 재발급 */
	public ResponseToken issueAccessToken(HttpServletRequest request, UserDTO userDetails){

		/* 요청 시 헤더에 담겨온 토큰 */
		String accessToken = request.getHeader("Authorization");
		String refreshToken = request.getHeader("Refresh-Token");

		if (jwtUtil.validateTokenExpired(accessToken)) {	// 액세스 토큰 만료

			log.info("accessToken 만료됨");

			if (!(jwtUtil.validateTokenExpired(refreshToken))	// 리프레시 토큰이 만료되지 않음
				&& jwtUtil.validateToken(refreshToken)) {	// 리프레시 토큰 유효

				/* 리프레시 토큰에서 클레임 정보 추출 */
				Claims claims = Jwts.parserBuilder()
					.setSigningKey(Keys.hmacShaKeyFor(environment.getProperty("token.secret").getBytes()))
					.build()
					.parseClaimsJws(refreshToken)
					.getBody();

				/* 클레임 정보에서 필요한 정보(userEmail) 가져오기 */
				String userEmail = claims.getSubject();

				// String accessToken = createAccessToken(userDetails, auth)

			}
		}
		// return ResponseToken.builder()
		// 	.ACCESS_TOKEN(accessToken)
		// 	.REFRESH_TOKEN(refreshToken)
		// 	.build();

		return null;
	}
}
