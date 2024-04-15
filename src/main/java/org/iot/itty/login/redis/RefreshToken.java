package org.iot.itty.login.redis;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
/* Lettuce를 사용하기 위해 redisHash를 작성 */
@RedisHash(value = "refreshToken")	// value: redis의 key값으로 사용, {value}:{@Id 값}
public class RefreshToken {

	@Id
	private String refreshToken;
	private String userEmail;
	private String accessToken;

}
