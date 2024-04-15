package org.iot.itty.article.aggregate;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trend_article_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrendArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trend_article_code_pk")
	private Integer trendArticlePk;

	@Column(name = "trend_article_url")
	private String trendArticleUrl;

	@Column(name = "trend_article_title")
	private String trendArticleTitle;

	@Column(name = "trend_article_image_url")
	private String trendArticleImageUrl;

	@Column(name = "trend_article_content")
	private String trendArticleContent;

	@Column(name = "trend_article_created_date")
	private Date trendArticleCreatedDate;

	@Column(name = "trend_article_category")
	private String trendArticleCategory;

	@Builder
	public TrendArticleEntity(Integer trendArticlePk, String trendArticleUrl, String trendArticleTitle,
		String trendArticleImageUrl, String trendArticleContent, Date trendArticleCreatedDate,
		String trendArticleCategory) {
		this.trendArticlePk = trendArticlePk;
		this.trendArticleUrl = trendArticleUrl;
		this.trendArticleTitle = trendArticleTitle;
		this.trendArticleImageUrl = trendArticleImageUrl;
		this.trendArticleContent = trendArticleContent;
		this.trendArticleCreatedDate = trendArticleCreatedDate;
		this.trendArticleCategory = trendArticleCategory;
	}
}
