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
@Table(name = "reply_like_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReplyLikeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_like_code_pk")
	private Integer likeCodePk;

	@Column(name = "user_code_fk")
	private Integer userCodeFk;

	@Column(name = "reply_code_fk")
	private Integer replyCodeFk;

	@Builder
	public ReplyLikeEntity(Integer likeCodePk, Integer userCodeFk, Integer replyCodeFk) {
		this.likeCodePk = likeCodePk;
		this.userCodeFk = userCodeFk;
		this.replyCodeFk = replyCodeFk;
	}
}
