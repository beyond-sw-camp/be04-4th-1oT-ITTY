package org.iot.itty.article.aggregate;

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
@Table(name = "scrap_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScrapEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scrap_code_pk")
	private Integer scrapCodePk;

	@Column(name = "user_code_fk")
	private Integer userCodeFk;

	@Column(name = "trend_article_code_fk")
	private Integer trendArticleCodeFk;

	@Builder
	public ScrapEntity(Integer scrapCodePk, Integer userCodeFk, Integer trendArticleCodeFk) {
		this.scrapCodePk = scrapCodePk;
		this.userCodeFk = userCodeFk;
		this.trendArticleCodeFk = trendArticleCodeFk;
	}
}
