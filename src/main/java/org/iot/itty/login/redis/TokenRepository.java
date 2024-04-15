package org.iot.itty.login.redis;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<RefreshToken, String> {
	Optional<Object> findByAccessToken(String accessToken);
}
