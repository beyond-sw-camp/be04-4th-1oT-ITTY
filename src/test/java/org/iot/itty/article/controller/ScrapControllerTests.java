// package org.iot.itty.article.controller;
//
//
// import java.util.List;
// import java.util.Map;
//
// import org.assertj.core.api.Assertions;
// import org.iot.itty.article.service.ScrapService;
// import org.iot.itty.article.vo.RequestAddScrap;
// import org.iot.itty.article.vo.RequestDeleteScrap;
// import org.iot.itty.article.vo.ResponseSelectAllScrapByUserCodeFk;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.transaction.annotation.Transactional;
//
// @SpringBootTest
// @AutoConfigureMockMvc
// @Transactional
// public class ScrapControllerTests {
//
// 	@Autowired
// 	private ScrapController scrapController;
//
// 	@Test
// 	@DisplayName("회원별 스크렙 게시글 리스트 출력 테스트")
// 	public void testSelectAllScrapByUserCodeFk() {
//
// 		// given
// 		int userCodeFK = 1;
// 		int userCodeFK2 = 33;
//
// 		// when
// 		ResponseEntity<List<ResponseSelectAllScrapByUserCodeFk>> response = scrapController.selectAllScrapByUserCodeFk(userCodeFK);
// 		ResponseEntity<List<ResponseSelectAllScrapByUserCodeFk>> response2 = scrapController.selectAllScrapByUserCodeFk(userCodeFK2);
//
// 		// then
// 		Assertions.assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(response2.getStatusCode());
// 	}
//
// 	@Test
// 	@DisplayName("게시글 스크랩 추가 테스트")
// 	public void testRegistScrap() {
//
// 		// given
// 		RequestAddScrap requestAddScrap = new RequestAddScrap();
// 		requestAddScrap.setUserCodeFk(1);
// 		requestAddScrap.setTrendArticleCodeFk(1);
//
// 		RequestAddScrap requestAddScrap2 = new RequestAddScrap();
// 		requestAddScrap2.setUserCodeFk(999);
// 		requestAddScrap2.setTrendArticleCodeFk(999);
//
// 		// when
// 		HttpStatusCode result = scrapController.registScrap(requestAddScrap).getStatusCode();
// 		HttpStatusCode result2 = scrapController.registScrap(requestAddScrap2).getStatusCode();
//
// 		// then
// 		Assertions.assertThat(HttpStatus.CREATED).isEqualTo(result);
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(result2);
//
// 	}
//
// 	@Test
// 	@DisplayName("게시글 스크랩 삭제 테스트")
// 	public void testDeleteScrap() {
//
// 		// given
// 		RequestDeleteScrap requestDeleteScrap = new RequestDeleteScrap();
// 		requestDeleteScrap.setUserCodeFk(1);
// 		requestDeleteScrap.setTrendArticleCodeFk(2);
//
// 		RequestDeleteScrap requestDeleteScrap2 = new RequestDeleteScrap();
// 		requestDeleteScrap2.setUserCodeFk(1);
// 		requestDeleteScrap2.setTrendArticleCodeFk(100);
//
//
// 		// when
// 		HttpStatusCode result = scrapController.deleteScrap(requestDeleteScrap).getStatusCode();
// 		HttpStatusCode result2 = scrapController.deleteScrap(requestDeleteScrap2).getStatusCode();
//
// 		// then
// 		Assertions.assertThat(HttpStatus.OK).isEqualTo(result);
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(result2);
//
// 	}
// }
