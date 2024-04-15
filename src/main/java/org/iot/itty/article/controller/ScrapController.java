package org.iot.itty.article.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iot.itty.article.service.ScrapService;
import org.iot.itty.article.vo.RequestAddScrap;
import org.iot.itty.article.vo.RequestDeleteScrap;
import org.iot.itty.article.vo.ResponseSelectAllScrapByUserCodeFk;
import org.iot.itty.dto.ScrapDTO;
import org.iot.itty.dto.TrendArticleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ScrapController {

	private final ModelMapper modelMapper;
	private final ScrapService scrapService;

	@Autowired
	public ScrapController(ModelMapper modelMapper, ScrapService scrapService) {
		this.modelMapper = modelMapper;
		this.scrapService = scrapService;
	}

	@GetMapping("/user/{userCodeFk}/scraps")
	public ResponseEntity<List<ResponseSelectAllScrapByUserCodeFk>> selectAllScrapByUserCodeFk(@PathVariable("userCodeFk") int userCodeFk) {
		List<TrendArticleDTO> scrappedTrendArticleDTOList = scrapService.selectAllScrapByUserCodeFk(userCodeFk);
		List<ResponseSelectAllScrapByUserCodeFk> responseSelectAllScrapByUserCodeFkList = new ArrayList<>();

		if (!scrappedTrendArticleDTOList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(scrappedTrendArticleDTOList
				.stream()
				.map(TrendArticleDTO -> modelMapper.map(TrendArticleDTO, ResponseSelectAllScrapByUserCodeFk.class))
				.toList()
			);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/scrap")
	public ResponseEntity<Map<String, String>> registScrap(@RequestBody RequestAddScrap requestAddScrap) {

		Map<String, String> result = new HashMap<>();
		try {
			ScrapDTO responseScrapDTO = scrapService.addScrap(requestAddScrap);
			result.put("message",
				"scrapped article #" + responseScrapDTO.getTrendArticleCodeFk() + " successfully.");

			return ResponseEntity.status(HttpStatus.CREATED).body(result);

		} catch (Exception e) {
			result.put("message",
				"Failed to scrap.");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}

	@DeleteMapping("/scrap")
	public ResponseEntity<Map<String, String>> deleteScrap(@RequestBody RequestDeleteScrap requestDeleteScrap) {
		String returnedMessage = scrapService.deleteScrap(requestDeleteScrap);

		Map<String, String> result = new HashMap<>();

		if (returnedMessage.equals("Successfully cancelled scrap from trend article.")) {
			result.put("message", returnedMessage);

			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}
}
