// package org.iot.itty.login.redis;
//
// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;
//
// @SpringBootTest
// public class RedisCacheTests {
//
// 	@Autowired private RedisTemplate<String, String> redisTemplate;
//
// 	@Test
// 	public void testStrings() throws Exception {
//
// 		//given
// 		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
// 		String key = "accessToken";
//
// 		// when
// 		valueOperations.set(key, "test");
//
// 		//then
// 		String value = valueOperations.get(key);
// 		Assertions.assertThat(value).isEqualTo("test");
// 	}
// }
