package org.iot.itty.article.repository;

import java.util.List;
import java.util.Map;

import org.iot.itty.article.aggregate.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
	List<ArticleEntity> findAllByArticleCategory(int articleCategory);

	List<ArticleEntity> findAllByUserCodeFk(int userCodeFk);
}
