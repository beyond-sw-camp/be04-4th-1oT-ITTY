package org.iot.itty.article.repository;

import org.iot.itty.article.aggregate.TrendArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendArticleRepository extends JpaRepository<TrendArticleEntity, Integer> {
	boolean existsByTrendArticleUrl(String trendArticleUrl);

	TrendArticleEntity findByTrendArticleUrl(String trendArticleUrl);
}
