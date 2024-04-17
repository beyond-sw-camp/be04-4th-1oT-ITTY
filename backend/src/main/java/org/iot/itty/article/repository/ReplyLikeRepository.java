package org.iot.itty.article.repository;

import java.util.List;

import org.iot.itty.article.aggregate.ReplyLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyLikeRepository extends JpaRepository<ReplyLikeEntity, Integer> {
	List<ReplyLikeEntity> findAllByUserCodeFk(int userCodeFk);

	ReplyLikeEntity findByReplyCodeFkAndUserCodeFk(int replyCode, int userCode);
}
