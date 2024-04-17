package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class RequestModifyFreeBoardArticle {
	private int articleCodePk;
	private String articleTitle;
	private String articleContent;
	private int userCodeFk;

	@Builder
	public RequestModifyFreeBoardArticle(int articleCodePk, String articleTitle, String articleContent,
		int userCodeFk) {
		this.articleCodePk = articleCodePk;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.userCodeFk = userCodeFk;
	}
}
