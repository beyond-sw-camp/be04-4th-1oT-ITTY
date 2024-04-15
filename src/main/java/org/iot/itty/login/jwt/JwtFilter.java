package org.iot.itty.login.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.iot.itty.login.exception.BlackToken;
import org.iot.itty.login.redis.TokenRepository;
import org.iot.itty.login.service.LoginService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* 요청을 보낸 회원이 헤더에 토큰을 가지고 있는 경우(=로그인된 회원) 동작하는 필터 */
public class JwtFilter extends OncePerRequestFilter {

	private final LoginService loginService;
	private final JwtUtil jwtUtil;
	private final TokenRepository tokenRepository;

	public JwtFilter(LoginService loginService, JwtUtil jwtUtil, TokenRepository tokenRepository) {
		this.loginService = loginService;
		this.jwtUtil = jwtUtil;
		this.tokenRepository = tokenRepository;
	}

	/* UsernamePasswordAuthentication보다 먼저 동작하는 필터 생성 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		// 헤더에서 토큰을 가져와 유효성 검사를 마친 후 변수에 저장
		String accessToken = jwtUtil.validAccessTokenHeader(request);

		// 특정 엔드포인트에 대한 요청은 토큰 검증을 하지 않고 처리
		String requestURI = request.getRequestURI();
		if (requestURI.equals("/regist") || requestURI.equals("/login")) {
			filterChain.doFilter(request, response);
			return;
		}

		filterChain.doFilter(request, response);

		// 토큰 없이 들어오는 요청을 모두 처리하기 위해 임시로 주석 처리
		// try {
		// 	// if(!StringUtils.hasText(accessToken))
		// 	// 	throw new NotExistingToken("토큰이 없습니다.");
		//
		// 	// 로그아웃 된 토큰인지 검사
		// 	validBlackToken(accessToken);
		//
		// 	// Jwt 토큰 만료기간 검증(getAuthentication에서 처리)
		// 	jwtUtil.validateTokenExpired(accessToken);
		//
		// 	// accessToken에서 인증 객체(Authentication) 추출
		// 	Authentication authentication = jwtUtil.getAuthentication(accessToken);
		// 	SecurityContextHolder.getContext().setAuthentication(authentication);
		//
		// 	filterChain.doFilter(request, response);
		// // 로그아웃된 토큰 - 401
		// } catch (BlackToken e){
		// 	sendResponse(response, e.getMessage(),
		// 		HttpStatus.UNAUTHORIZED.value(), HttpStatus.PRECONDITION_FAILED.getReasonPhrase());
		// 	return;
		// } catch (NotExistingToken e) {
		// 	sendResponse(response, e.getMessage(),
		// 		HttpStatus.PRECONDITION_FAILED.value(), HttpStatus.PRECONDITION_FAILED.getReasonPhrase());
		// // 정상적이지 않은 토큰 - 401
		// } catch (NotValidToken e) {
		// 	sendResponse(response, e.getMessage(),
		// 		HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		// 	return;
		// } catch (Exception e) { //나머지 서버 에러-500
		// 	sendResponse(response, e.getMessage(),
		// 		HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		// 	return;
		// }
	}

	/* 로그아웃 토큰 확인 */
	private void validBlackToken(String accessToken) {

		// Redis에 있는 엑세스 토큰인 경우 로그아웃 처리된 엑세스 토큰임.
		String blackToken = String.valueOf(tokenRepository.findByAccessToken(accessToken));
		if(StringUtils.hasText(blackToken))
			throw new BlackToken("로그아웃 처리된 엑세스 토큰입니다.");
	}

	private void sendResponse(HttpServletResponse response, String message, int code, String status ) throws IOException {

		List<Object> result = new ArrayList<>();
		result.add(message);
		result.add(String.valueOf(code));		// HttpStatus 상태 코드
		result.add(status);						// HttpStatus 상태 문구


		// BaseErrorResult result = new BaseErrorResult(message, String.valueOf(code), status);

		ObjectMapper objectMapper = new ObjectMapper();

		String res = objectMapper.writeValueAsString(result);
		response.setStatus(code);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(res);
	}
}
