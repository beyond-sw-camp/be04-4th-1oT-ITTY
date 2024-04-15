package org.iot.itty.dto;

import lombok.Data;

@Data
public class ReplyLikeDTO {
	private int replyLikeCodePk;
	private int userCodeFk;
	private int replyCodeFk;
}
