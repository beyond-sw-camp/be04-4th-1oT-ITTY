package org.iot.itty.login.jwt;

import org.iot.itty.login.redis.BlackToken;
import org.iot.itty.login.redis.BlackTokenRepository;
import org.iot.itty.login.redis.TokenRepository;
import org.iot.itty.login.service.LoginService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/* 받아온 토큰을 분해 */
@Slf4j
@Component
public class JwtUtil {

	private final Key key;
	private final LoginService loginService;
	private final long accessTokenExpTime;
	private final TokenRepository tokenRepository;
	private final BlackTokenRepository blackTokenRepository;

	public JwtUtil(
		@Value("${token.secret}") String secretKey,
		@Value("${token.expiration_time}") long accessTokenExpTime,
		LoginService loginService,
		TokenRepository tokenRepository,
		BlackTokenRepository blackTokenRepository) {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
		this.loginService = loginService;
		this.accessTokenExpTime = accessTokenExpTime;
		this.tokenRepository = tokenRepository;
		this.blackTokenRepository = blackTokenRepository;
	}

	/* AccessToken에서 인증 객체(Authentication) 추출 */
	public Authentication getAuthentication(String token) {
		/* User 객체에서 토큰에 담긴 userEmail과 일치하는 회원의 사용자 인증 정보를 가져와 저장 */
		UserDetails userDetails = loginService.loadUserByUsername(this.getUserEmail(token));

		Claims claims = parseClaims(token);
		log.info("AcessToken에 담긴 Claims 확인: " + claims);

		if (claims.get("auth") == null) {
			throw new RuntimeException("권한 정보가 없는 토큰입니다.");
		}

		Collection<? extends GrantedAuthority> authorities =
			Arrays.stream(claims.get("auth").toString()
					.replace("[", "").replace("]", "").split(", "))
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	/* 구문 분석이 완료된 토큰에서 userEmail 추출 */
	public String getUserEmail(String token) {
		return parseClaims(token).getSubject();
	}

	/* 토큰에서 Claims 추출 */
	private Claims parseClaims(String token) {
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) {
			return e.getClaims();
		}
	}

	/* 액세스 토큰 유효성 검증(true/false) */
	public boolean validateToken(String token) {
		// try {
		// 	Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
		// 	return true;
		// } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
		// 	log.info("Invalid JWT Token {}", e);
		// } catch (ExpiredJwtException e) {
		// 	log.info("expired JWT Toekn {}", e);
		// } catch (UnsupportedJwtException e) {
		// 	log.info("Unsupported JWT Token {}", e);
		// } catch (IllegalArgumentException e) {
		// 	log.info("JWT claims strig si empty {}", e);
		// }
		// return false;

		if(token != null) {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
				return true;
		}
		return false;
	}

	/* 액세스 토큰 유효성 검증 후 토큰 반환 */
	public String validAccessTokenHeader(HttpServletRequest request) {

		// Header에서 Authorization 추출
		String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			// "Bearer " 부분을 제외하고 토큰 문자열 추출
			String accessToken = authorizationHeader.substring(7);

			if (validateToken(accessToken)) {
				Authentication authentication = getAuthentication(accessToken);
				SecurityContextHolder.getContext().setAuthentication(authentication);

				return accessToken;
			}
		}
		return null;
	}

	/* 액세스 토큰의 유효시간을 가져오는 메소드 */
	public Long getExpiration(String accessToken) {
		Date expiration = Jwts.parserBuilder().setSigningKey(key)
			.build().parseClaimsJws(accessToken).getBody().getExpiration();

		long now = new Date().getTime();

		return expiration.getTime() - now;
	}

	/* 액세스 토큰의 유효시간을 0으로 설정 */
	public String setExpirationToZero(String accessToken) {
		try {
			// 주어진 액세스 토큰을 파싱하여 클레임을 가져옴
			Claims claims = Jwts.parserBuilder().setSigningKey(key)
				.build().parseClaimsJws(accessToken).getBody();

			// 현재 시간을 가져옴
			Date now = new Date();

			// 만료 시간을 현재 시간으로 설정하여 만료되도록 함
			claims.setExpiration(now);

			// 새로운 토큰을 생성하여 반환
			return Jwts.builder()
				.setClaims(claims)
				.signWith(key)
				.compact();
		} catch (Exception e) {
			// 토큰을 파싱하거나 새로운 토큰을 생성하는 중에 예외가 발생한 경우
			// 예외를 처리하거나 적절한 방법으로 처리하십시오.
			e.printStackTrace();
			return null;
		}
	}

	/* 토큰 유효시간 만료 검증 */
	public boolean validateTokenExpired(String Token) {
		long expiration = getExpiration(Token);
		System.out.println("유효시간 검증: " + expiration);

		if (expiration <= 0)	// 토큰이 만료된 경우
			return false;

		return true;	// 토큰이 유효한 경우
	}

	/* 리프레시 토큰 유효성 검증 */
	public boolean validateRefreshToken(String refreshToken) {

		boolean isTrue = true;
		String storedRefreshToken =
			tokenRepository.findById(refreshToken).get().toString();

		System.out.println("storedRefreshToken: " + storedRefreshToken);

		if (storedRefreshToken == null) {
			isTrue = false;
			return isTrue;
		}
		return isTrue;
	}

	/* 로그아웃 시 액세스 토큰 블랙리스트에 추가 */
	@Transactional
	public void destroyToken(HttpServletRequest request) {

		String accessToken = validAccessTokenHeader(request);
		System.out.println("검증 완료 된 accessToken: " + accessToken);

		String userEmail = getUserEmail(accessToken);

		// long tokenExpiration = getExpiration(accessToken) * 60 * 1000;
		// System.out.println("token 만료 시간(Millis): " + tokenExpiration);
		//
		// // 남은 유효시간을 0으로 설정
		// long expiration = tokenExpiration - tokenExpiration;
		// System.out.println("남은 유효 시간(Minute): " + expiration);

		String expiredToken = setExpirationToZero(accessToken);

		// expiredToken

		tokenRepository.deleteById(accessToken);

		BlackToken blackToken = new BlackToken();
		blackToken.setAccessToken(expiredToken);
		blackToken.setUserEmail(userEmail);
		// blackToken.setExpriation(expiration);

		blackTokenRepository.save(blackToken);
	}

	@Transactional
	public Optional<?> verifyAccessToken(HttpServletRequest request) {
		String accessToken = validAccessTokenHeader(request);
		String userEmail = getUserEmail(accessToken);

		Optional<BlackToken> blackToken = blackTokenRepository.findById(accessToken);

		return blackToken.filter(black -> black.getAccessToken().equals(accessToken))
			.map(black -> Optional.empty()).orElse(Optional.of(blackToken));
	}
}
