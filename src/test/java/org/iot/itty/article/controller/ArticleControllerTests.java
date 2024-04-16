// package org.iot.itty.article.controller;
//
// import static org.hamcrest.Matchers.*;
// import static org.mockito.BDDMockito.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
// import java.util.Date;
// import java.util.List;
// import java.util.stream.Stream;
//
// import org.assertj.core.api.Assertions;
// import org.iot.itty.article.aggregate.ArticleEntity;
// import org.iot.itty.article.repository.ArticleRepository;
// import org.iot.itty.article.service.ArticleService;
// import org.iot.itty.article.vo.RequestDeleteBulletinArticle;
// import org.iot.itty.article.vo.RequestModifyFreeBoardArticle;
// import org.iot.itty.article.vo.RequestRegistFreeBoardArticle;
// import org.iot.itty.article.vo.ResponseArticle;
// import org.iot.itty.article.vo.ResponseDeleteFreeBoardArticle;
// import org.iot.itty.article.vo.ResponseModifyFreeBoardArticle;
// import org.iot.itty.article.vo.ResponseRegistFreeBoardArticle;
// import org.iot.itty.article.vo.ResponseSelectAllArticleByUserCodeFk;
// import org.iot.itty.dto.ArticleDTO;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.provider.Arguments;
// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.transaction.annotation.Transactional;
//
// @SpringBootTest
// @Transactional
// class ArticleControllerTests {
//
// 	@Autowired
// 	private ArticleController articleController;
//
// 	@Autowired
// 	private ArticleService articleService;
//
// 	@Autowired
// 	private ArticleRepository articleRepository;
//
// 	@Autowired
// 	private ModelMapper modelMapper;
//
//
// 	// @Test
// 	// @DisplayName("자유게시글 한개 조회 테스트")
// 	// public void selectBulletinArticleByArticleCodePkTest() {
// 	//
// 	// 	// given
// 	// 	int articleCodePk1 = 1;
// 	// 	int articleCodePk2 = 100;
// 	//
// 	// 	// when
// 	// 	ResponseEntity<ResponseArticle> response1 = articleController.selectBulletinArticleByArticleCodePk(articleCodePk1);
// 	// 	ResponseEntity<ResponseArticle> response2 = articleController.selectBulletinArticleByArticleCodePk(articleCodePk2);
// 	//
// 	// 	// then
// 	// 	Assertions.assertThat(HttpStatus.OK).isEqualTo(response1.getStatusCode());
// 	// 	Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(response2.getStatusCode());
// 	// }
// 	//
// 	// @Test
// 	// @DisplayName("작성자별 자유게시글 리스트 조회 테스트")
// 	// public void selectAllBulletinArticleByUserCodeFkTest() {
// 	//
// 	// 	// given
// 	// 	int userCodeFk1 = 3;
// 	// 	int userCodeFk2 = 40;
// 	//
// 	// 	// when
// 	// 	ResponseEntity<List<ResponseSelectAllArticleByUserCodeFk>> response1 = articleController.selectAllBulletinArticleByUserCodeFk(userCodeFk1);
// 	// 	ResponseEntity<List<ResponseSelectAllArticleByUserCodeFk>> response2 = articleController.selectAllBulletinArticleByUserCodeFk(userCodeFk2);
// 	//
// 	// 	// then
// 	// 	Assertions.assertThat(HttpStatus.OK).isEqualTo(response1.getStatusCode());
// 	// 	Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(response2.getStatusCode());
// 	// }
// 	//
// 	// @Test
// 	// @DisplayName("자유게시판 게시글 등록 테스트")
// 	// public void registBulletinArticleTest() {
// 	//
// 	// 	// given
// 	// 	RequestRegistFreeBoardArticle request = RequestRegistFreeBoardArticle.builder()
// 	// 		.articleTitle("테스트 제목")
// 	// 		.articleContent("테스트 내용")
// 	// 		.userCodeFk(1)
// 	// 		.build();
// 	//
// 	// 	// when
// 	// 	ArticleDTO requestArticleDTO = articleService.registFreeBoardArticle(modelMapper.map(request, ArticleDTO.class));
// 	// 	System.out.println("Expected: " + requestArticleDTO);
// 	//
// 	// 	ArticleDTO responseArticleDTO = modelMapper.map(articleRepository.findAll().get(articleRepository.findAll().size() - 1), ArticleDTO.class);
// 	// 	System.out.println("Actual: " + responseArticleDTO);
// 	//
// 	// 	// then
// 	// 	Assertions.assertThat(requestArticleDTO.toString()).isEqualTo(responseArticleDTO.toString());
// 	// }
// 	//
// 	// @Test
// 	// @DisplayName("자유게시판 게시글 수정 테스트")
// 	// public void modifyBulletinArticleTest() {
// 	//
// 	// 	// given
// 	// 	RequestModifyFreeBoardArticle request = RequestModifyFreeBoardArticle.builder()
// 	// 		.articleCodePk(1)
// 	// 		.articleTitle("수정 제목")
// 	// 		.articleContent("수정 내용")
// 	// 		.userCodeFk(1)
// 	// 		.build();
// 	//
// 	// 	// when
// 	// 	ArticleDTO requestArticleDTO = articleService.modifyFreeBoardArticle(modelMapper.map(request, ArticleDTO.class));
// 	// 	System.out.println("Expected: " + requestArticleDTO);
// 	//
// 	// 	ArticleDTO responseArticleDTO = modelMapper.map(articleRepository.findById(request.getArticleCodePk()), ArticleDTO.class);
// 	// 	System.out.println("Actual: " + responseArticleDTO);
// 	//
// 	// 	// then
// 	// 	Assertions.assertThat(requestArticleDTO.toString()).isEqualTo(responseArticleDTO.toString());
// 	// }
// 	//
// 	// @Test
// 	// @DisplayName("자유게시판 게시글 삭제 테스트")
// 	// public void deleteBulletinArticleTest() {
// 	//
// 	// 	// given
// 	// 	RequestDeleteBulletinArticle request = RequestDeleteBulletinArticle.builder()
// 	// 		.articleCodePk(1)
// 	// 		.build();
// 	//
// 	// 	// when
// 	// 	ResponseEntity<ResponseDeleteFreeBoardArticle> response = articleController.deleteBulletinArticle(request);
// 	//
// 	// 	// then
// 	// 	Assertions.assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
// 	// }
// }
