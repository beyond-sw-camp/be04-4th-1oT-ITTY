package org.iot.itty.login.vo;

import lombok.Data;

@Data
public class ResponseRegist {
	int userCodePk;
	String userEmail;
	String status;
	String message;
}
