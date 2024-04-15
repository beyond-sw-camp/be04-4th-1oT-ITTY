package org.iot.itty.login.vo;

import lombok.Data;

@Data
public class RequestRegist {
	String userEmail;
	String userPassword;
	String userName;
	String userPhoneNumber;
	String userNickname;
}
