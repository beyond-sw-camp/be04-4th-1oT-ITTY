package org.iot.itty.article.repository;

import java.util.List;

import org.iot.itty.article.aggregate.ScrapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapRepository extends JpaRepository<ScrapEntity, Integer> {
	List<ScrapEntity> findAllByUserCodeFk(int userCodeFk);

	ScrapEntity findByUserCodeFkAndTrendArticleCodeFk(int userCodeFk, int trendArticleCodeFk);
}
