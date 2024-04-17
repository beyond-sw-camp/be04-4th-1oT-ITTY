package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDeleteReplyLike {
	private int userCode;
	private int replyCode;
}
