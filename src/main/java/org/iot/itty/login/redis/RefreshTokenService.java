package org.iot.itty.login.redis;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
	private final TokenRepository tokenRepository;

	@Transactional
	public void saveTokenInfo(String userEmail, String refreshToken, String accessToken) {
		tokenRepository.save(new RefreshToken(userEmail, refreshToken, accessToken));
	}

	// @Transactional
	// public void removeRefreshToken(String accessToken) {
	// 	tokenRepository.findByAccessToken(accessToken)
	// 		.ifPresent(refreshToken -> tokenRepository.delete(null));
	// }
}
