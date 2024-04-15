package org.iot.itty.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TrendArticleDTO {
	private Integer trendArticlePk;
	private String trendArticleUrl;
	private String trendArticleTitle;
	private String trendArticleImageUrl;
	private String trendArticleContent;
	private Date trendArticleCreatedDate;
	private String trendArticleCategory;
}
