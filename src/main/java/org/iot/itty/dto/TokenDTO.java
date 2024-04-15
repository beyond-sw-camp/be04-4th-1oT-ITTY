package org.iot.itty.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
	private String accessToken;
	private String refreshToken;
	private long accessTokenExpTime;
	private long refreshTokenExpTime;
	private String type;
}
