package org.iot.itty.article.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.iot.itty.article.aggregate.TrendArticleEntity;
import org.iot.itty.article.repository.TrendArticleRepository;
import org.iot.itty.dto.TrendArticleDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;

@Service
public class TrendArticleServiceImpl implements TrendArticleService{

	private final ModelMapper modelMapper;
	private final TrendArticleRepository trendArticleRepository;
	private static final String URL = "https://www.bloter.net/news/articleList.html?page=1&total=33475&box_idxno=&sc_section_code=S1N4&view_type=sm";

	@Autowired
	public TrendArticleServiceImpl(ModelMapper modelMapper, TrendArticleRepository trendArticleRepository) {
		this.modelMapper = modelMapper;
		this.trendArticleRepository = trendArticleRepository;
	}

	@Override
	public List<TrendArticleDTO> selectAllTrendArticle() {
		List<TrendArticleEntity> trendArticleEntityList = trendArticleRepository.findAll();

		return trendArticleEntityList
			.stream()
			.map(TrendArticleEntity -> modelMapper.map(TrendArticleEntity, TrendArticleDTO.class))
			.toList();
	}

	@Transactional
	@Override
	public List<TrendArticleDTO> addTrendArticle() throws IOException, ParseException {
		List<TrendArticleEntity> trendArticleEntityList = new ArrayList<>();
		Document document = Jsoup.connect(URL).get();
		Elements contents = document.select("section ul.type2 li");

		String[] infoArr;

		for (Element content : contents) {
			infoArr = content.select("span em").text().split(" ");
			String date = infoArr[3].replace(".", "-");
			String time = " " + infoArr[4] + ":00";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			TrendArticleEntity trendArticleEntity = TrendArticleEntity.builder()
				.trendArticleUrl(content.select("a").attr("abs:href"))
				.trendArticleTitle(content.select("h2 a").text())
				.trendArticleImageUrl(content.select("a img").attr("abs:src"))
				.trendArticleContent(content.select("p a").text().substring(0, 255))
				.trendArticleCategory(infoArr[0])
				.trendArticleCreatedDate(formatter.parse(date + time))
				.build();
			// System.out.println(trendArticleEntity.getTrendArticleUrl());
			boolean isExist = trendArticleRepository.existsByTrendArticleUrl(trendArticleEntity.getTrendArticleUrl());

			if (!isExist) {
				trendArticleEntityList.add(trendArticleRepository.save(trendArticleEntity));
			}
		}

		if (trendArticleEntityList.isEmpty()) {
			return null;
		}

		return trendArticleEntityList
			.stream()
			.map(TrendArticleEntity -> modelMapper.map(TrendArticleEntity, TrendArticleDTO.class))
			.toList();
	}

	@Override
	public String deleteTrendArticle(int trendArticleCodePk) {
		try {
			trendArticleRepository.deleteById(trendArticleCodePk);
			return "Successfully deleted trend article.";
		} catch (Exception e) {
			return "Failed to delete trend article.";
		}
	}
}
