package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestRegistReply {
	private String replyContent;
	private int userCodeFk;
	private int articleCodeFk;
}
