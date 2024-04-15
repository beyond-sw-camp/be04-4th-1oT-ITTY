package org.iot.itty.article.service;

import java.util.List;

import org.iot.itty.dto.ArticleDTO;

public interface ArticleService {
	List<ArticleDTO> selectAllArticleFromFreeBoard();

	ArticleDTO selectFreeBoardArticleByArticleCodePk(int articleCodePk);

	List<ArticleDTO> selectAllArticleByUserCodeFk(int userCodeFk);

	ArticleDTO registFreeBoardArticle(ArticleDTO requestArticleDTO);

	ArticleDTO modifyFreeBoardArticle(ArticleDTO requestArticleDTO);

	String deleteFreeBoardArticle(int articleCodePk);
}
