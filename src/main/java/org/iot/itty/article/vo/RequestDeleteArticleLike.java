package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDeleteArticleLike {
	private int articleCode;
	private int userCode;
}
