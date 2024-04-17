package org.iot.itty.article.service;

import java.util.List;

import org.iot.itty.article.vo.RequestAddScrap;
import org.iot.itty.article.vo.RequestDeleteScrap;
import org.iot.itty.dto.ScrapDTO;
import org.iot.itty.dto.TrendArticleDTO;

public interface ScrapService {
	List<TrendArticleDTO> selectAllScrapByUserCodeFk(int userCodeFk);

	ScrapDTO addScrap(RequestAddScrap requestAddScrap);

	String deleteScrap(RequestDeleteScrap requestDeleteScrap);
}
