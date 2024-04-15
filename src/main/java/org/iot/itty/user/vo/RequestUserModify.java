package org.iot.itty.user.vo;

import lombok.Data;

@Data
public class RequestUserModify {

	private int userCodePk;
	private String userNickname;
	private String userIntroduction;
	private String userName;
	private String userPassword;
	private String userPhoneNumber;
}
