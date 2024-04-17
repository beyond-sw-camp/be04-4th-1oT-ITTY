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
@Table(name = "article_like_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleLikeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_like_code_pk")
	private Integer articleLikeCodePk;

	@Column(name = "article_code_fk")
	private Integer articleCodeFk;

	@Column(name = "user_code_fk")
	private Integer userCodeFk;

	@Builder
	public ArticleLikeEntity(Integer articleLikeCodePk, Integer articleCodeFk, Integer userCodeFk) {
		this.articleLikeCodePk = articleLikeCodePk;
		this.articleCodeFk = articleCodeFk;
		this.userCodeFk = userCodeFk;
	}
}
