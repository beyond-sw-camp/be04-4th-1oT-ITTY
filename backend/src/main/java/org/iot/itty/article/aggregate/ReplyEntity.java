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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReplyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_code_pk")
	private Integer replyCodePk;

	@Column(name = "reply_content")
	private String replyContent;

	@Column(name = "user_code_fk")
	private Integer userCodeFk;

	@Column(name = "article_code_fk")
	private Integer articleCodeFk;

	@Column(name = "reply_created_date")
	private Date replyCreatedDate;

	@Column(name = "reply_last_updated_date")
	private Date replyLastUpdatedDate;

	@Builder
	public ReplyEntity(Integer replyCodePk, String replyContent, Integer userCodeFk, Integer articleCodeFk,
		Date replyCreatedDate, Date replyLastUpdatedDate) {
		this.replyCodePk = replyCodePk;
		this.replyContent = replyContent;
		this.userCodeFk = userCodeFk;
		this.articleCodeFk = articleCodeFk;
		this.replyCreatedDate = replyCreatedDate;
		this.replyLastUpdatedDate = replyLastUpdatedDate;
	}
}
