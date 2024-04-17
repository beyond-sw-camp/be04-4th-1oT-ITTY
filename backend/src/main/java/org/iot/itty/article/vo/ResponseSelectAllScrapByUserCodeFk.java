package org.iot.itty.article.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseSelectAllScrapByUserCodeFk {
	private Integer trendArticlePk;
	private String trendArticleUrl;
	private String trendArticleTitle;
	private String trendArticleImageUrl;
	private String trendArticleContent;
	private Date trendArticleCreatedDate;
	private String trendArticleCategory;
}
