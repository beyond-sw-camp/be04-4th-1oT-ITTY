package org.iot.itty.article.vo;

import java.util.Date;

import org.iot.itty.dto.UserDTO;

import lombok.Data;

@Data
public class ResponseSelectReplyByArticleCodeFk {
	private int replyCodePk;
	private String replyContent;
	private int userCodeFk;
	private int articleCodeFk;
	private Date replyCreatedDate;
	private Date replyLastUpdatedDate;
	private UserDTO userDTO;
}
