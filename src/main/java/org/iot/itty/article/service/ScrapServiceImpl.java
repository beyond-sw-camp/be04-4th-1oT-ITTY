package org.iot.itty.article.service;

import java.util.ArrayList;
import java.util.List;

import org.iot.itty.article.aggregate.ScrapEntity;
import org.iot.itty.article.aggregate.TrendArticleEntity;
import org.iot.itty.article.repository.ScrapRepository;
import org.iot.itty.article.repository.TrendArticleRepository;
import org.iot.itty.article.vo.RequestAddScrap;
import org.iot.itty.article.vo.RequestDeleteScrap;
import org.iot.itty.dto.ScrapDTO;
import org.iot.itty.dto.TrendArticleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScrapServiceImpl implements ScrapService{

	private ModelMapper modelMapper;
	private ScrapRepository scrapRepository;
	private TrendArticleRepository trendArticleRepository;

	@Autowired
	public ScrapServiceImpl(ModelMapper modelMapper, ScrapRepository scrapRepository, TrendArticleRepository trendArticleRepository) {
		this.modelMapper = modelMapper;
		this.scrapRepository = scrapRepository;
		this.trendArticleRepository = trendArticleRepository;
	}

	@Override
	public List<TrendArticleDTO> selectAllScrapByUserCodeFk(int userCodeFk) {
		List<ScrapEntity> scrapEntityList = scrapRepository.findAllByUserCodeFk(userCodeFk);
		List<TrendArticleDTO> trendArticleDTOList = new ArrayList<>();

		for (ScrapEntity scrapEntity : scrapEntityList) {
			TrendArticleEntity trendArticleEntity = trendArticleRepository.findById(scrapEntity.getTrendArticleCodeFk()).orElseThrow(IllegalAccessError::new);
			trendArticleDTOList.add(modelMapper.map(trendArticleEntity, TrendArticleDTO.class));
		}
		return trendArticleDTOList;
	}

	@Transactional
	@Override
	public ScrapDTO addScrap(RequestAddScrap requestAddScrap) {
		ScrapEntity scrapEntity = ScrapEntity.builder()
			.userCodeFk(requestAddScrap.getUserCodeFk())
			.trendArticleCodeFk(requestAddScrap.getTrendArticleCodeFk())
			.build();
		return modelMapper.map(scrapRepository.save(scrapEntity), ScrapDTO.class);
	}

	@Transactional
	@Override
	public String deleteScrap(RequestDeleteScrap requestDeleteScrap) {
		try {
			ScrapEntity scrapEntity = scrapRepository.findByUserCodeFkAndTrendArticleCodeFk(
				requestDeleteScrap.getUserCodeFk(), requestDeleteScrap.getTrendArticleCodeFk()
			);
			if (scrapEntity != null) {
				scrapRepository.deleteById(scrapEntity.getScrapCodePk());
				return "Successfully cancelled scrap from trend article.";
			} else {
				return "Error: the scrap you want to cancel does not exist.";
			}
		} catch (Exception e) {
			return "Error: failed to cancel scrap from trend article.\n" + e.getMessage();
		}
	}
}
