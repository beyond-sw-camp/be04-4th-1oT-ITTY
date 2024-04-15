package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class RequestDeleteBulletinArticle {
	private int articleCodePk;

	@Builder

	public RequestDeleteBulletinArticle(int articleCodePk) {
		this.articleCodePk = articleCodePk;
	}
}
