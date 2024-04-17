package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestAddArticleLike {
	private int articleCode;
	private int userCode;
}
