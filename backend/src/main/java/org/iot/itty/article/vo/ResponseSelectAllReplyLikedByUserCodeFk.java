package org.iot.itty.article.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseSelectAllReplyLikedByUserCodeFk {
	private int replyCodePk;
	private String replyContent;
	private int userCodeFk;
	private int articleCodeFk;
	private Date replyCreatedDate;
	private Date replyLastUpdatedDate;
}
