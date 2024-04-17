package org.iot.itty.login.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import lombok.Data;

@Data
@RedisHash(value = "blackToken")	// value: redis의 key값으로 사용, {value}:{@Id 값}
public class BlackToken {
	@Id
	private String accessToken;
	private String userEmail;

	@TimeToLive(unit = TimeUnit.MINUTES)
	private long expriation;
}
