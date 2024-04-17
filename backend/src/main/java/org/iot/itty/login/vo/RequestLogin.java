package org.iot.itty.login.vo;
import lombok.Data;

@Data
public class RequestLogin {
	private String userEmail;
	private String userPassword;
}
