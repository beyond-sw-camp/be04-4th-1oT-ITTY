package org.iot.itty.article.repository;

import java.util.List;

import org.iot.itty.article.aggregate.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
	List<ReplyEntity> findAllByArticleCodeFk(int articleCodePk);

	List<ReplyEntity> findAllByUserCodeFk(int userCodeFk);
}
