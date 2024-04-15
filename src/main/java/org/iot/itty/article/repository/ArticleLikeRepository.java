package org.iot.itty.article.repository;

import java.util.List;

import org.iot.itty.article.aggregate.ArticleLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleLikeRepository extends JpaRepository<ArticleLikeEntity, Integer> {
	List<ArticleLikeEntity> findAllByUserCodeFk(int userCodeFk);

	ArticleLikeEntity findByArticleCodeFkAndUserCodeFk(int articleCode, int userCode);
}
