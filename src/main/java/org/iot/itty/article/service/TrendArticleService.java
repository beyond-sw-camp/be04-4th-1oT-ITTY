package org.iot.itty.article.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.iot.itty.dto.TrendArticleDTO;

public interface TrendArticleService {
	List<TrendArticleDTO> selectAllTrendArticle();

	List<TrendArticleDTO> addTrendArticle() throws IOException, ParseException;

	String deleteTrendArticle(int trendArticleCodePk);
}
