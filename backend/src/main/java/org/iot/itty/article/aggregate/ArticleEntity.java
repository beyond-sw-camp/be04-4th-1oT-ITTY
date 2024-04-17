package org.iot.itty.article.aggregate;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_code_pk")
	private Integer articleCodePk;

	@Column(name = "article_title")
	private String articleTitle;

	@Column(name = "article_content")
	private String articleContent;

	@Column(name = "article_created_date")
	private Date articleCreatedDate;

	@Column(name = "article_last_updated_date")
	private Date articleLastUpdatedDate;

	@Column(name = "user_code_fk")
	private int userCodeFk;

	@Column(name = "article_category")
	private int articleCategory;

	@Column(name = "article_view_count")
	private int articleViewCount;

	@Builder
	public ArticleEntity(
		Integer articleCodePk,
		String articleTitle,
		String articleContent,
		Date articleCreatedDate,
		Date articleLastUpdatedDate,
		int userCodeFk,
		int articleCategory,
		int articleViewCount
	)
	{
		this.articleCodePk = articleCodePk;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleCreatedDate = articleCreatedDate;
		this.articleLastUpdatedDate = articleLastUpdatedDate;
		this.userCodeFk = userCodeFk;
		this.articleCategory = articleCategory;
		this.articleViewCount = articleViewCount;
	}
}
