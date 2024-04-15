package org.iot.itty.login.vo;

import lombok.Data;

@Data
public class ResponseToken {
	private String accessToken;
	private String refreshToken;


	public ResponseToken(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
