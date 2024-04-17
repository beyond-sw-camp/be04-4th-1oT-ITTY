package org.iot.itty.user.vo;

import lombok.Data;

@Data
public class ResponseFollowing {
	private int userCodePk;
	private String userEmail;
	private String userPhoneNumber;
	private String userRole;
	private String userNickname;
	private String userPassword;
	private String userIntroduction;
	private int userDeleteStatus;
}
