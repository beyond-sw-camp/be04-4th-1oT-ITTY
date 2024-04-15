package org.iot.itty.article.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class RequestRegistFreeBoardArticle {
	private String articleTitle;
	private String articleContent;
	private int userCodeFk;

	@Builder
	public RequestRegistFreeBoardArticle(String articleTitle, String articleContent, int userCodeFk) {
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.userCodeFk = userCodeFk;
	}
}
