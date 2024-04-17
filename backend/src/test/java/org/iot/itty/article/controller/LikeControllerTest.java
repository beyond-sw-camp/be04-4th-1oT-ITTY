// package org.iot.itty.article.controller;
//
// import static org.junit.jupiter.api.Assertions.*;
//
// import java.util.Map;
//
// import org.assertj.core.api.Assertions;
// import org.iot.itty.article.vo.RequestAddArticleLike;
// import org.iot.itty.article.vo.RequestAddReplyLike;
// import org.iot.itty.article.vo.RequestDeleteArticleLike;
// import org.iot.itty.article.vo.RequestDeleteReplyLike;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.transaction.annotation.Transactional;
//
// @SpringBootTest
// @Transactional
// class LikeControllerTest {
//
// 	@Autowired
// 	LikeController likeController;
//
// 	@Test
// 	@DisplayName("회원이 좋아요 누른 게시글 리스트, 댓글 리스트 조회")
// 	void selectAllLikeByUserCodeFk() {
//
// 		// given
// 		int userCodeFk1 = 1;
// 		int userCodeFk2 = 30;
//
// 		// when
// 		ResponseEntity<Map<String, Object>> response1 = likeController.selectAllLikeByUserCodeFk(userCodeFk1);
// 		ResponseEntity<Map<String, Object>> response2 = likeController.selectAllLikeByUserCodeFk(userCodeFk2);
//
// 		// then
// 		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
// 		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//
// 	}
//
// 	@Test
// 	@DisplayName("회원이 좋아요 누른 게시글 추가")
// 	void registArticleLike() {
//
// 		// given
// 		RequestAddArticleLike requestAddArticleLike1 =
// 			RequestAddArticleLike.builder().articleCode(1).userCode(1).build();
// 		RequestAddArticleLike requestAddArticleLike2 =
// 			RequestAddArticleLike.builder().articleCode(30).userCode(30).build();
//
// 		// when
// 		ResponseEntity<Map<String, String>> registArticleLike1 = likeController.registArticleLike(
// 			requestAddArticleLike1);
// 		ResponseEntity<Map<String, String>> registArticleLike2 = likeController.registArticleLike(
// 			requestAddArticleLike2);
//
// 		// then
// 		Assertions.assertThat(registArticleLike1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
// 		Assertions.assertThat(registArticleLike2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
// 	}
//
// 	@Test
// 	@DisplayName("회원이 좋아요 누른 게시글 삭제")
// 	void deleteArticleLike() {
// 		// given
// 		RequestDeleteArticleLike requestDeleteArticleLike1 =
// 			RequestDeleteArticleLike.builder().articleCode(1).userCode(1).build();
// 		RequestDeleteArticleLike requestDeleteArticleLike2 =
// 			RequestDeleteArticleLike.builder().articleCode(30).userCode(30).build();
//
// 		// when
// 		ResponseEntity<Map<String, String>> response1 = likeController.deleteArticleLike(requestDeleteArticleLike1);
// 		ResponseEntity<Map<String, String>> response2 = likeController.deleteArticleLike(requestDeleteArticleLike2);
//
// 		// then
// 		Assertions.assertThat(HttpStatus.OK).isEqualTo(response1.getStatusCode());
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(response2.getStatusCode());
//
// 	}
//
// 	@Test
// 	@DisplayName("회원이 좋아요 누른 댓글 추가")
// 	void registReplyLike() {
// 		// given
// 		RequestAddReplyLike requestAddReplyLike1 =
// 			RequestAddReplyLike.builder().replyCode(1).userCode(1).build();
// 		RequestAddReplyLike requestAddReplyLike2 =
// 			RequestAddReplyLike.builder().replyCode(50).userCode(30).build();
//
// 		// when
// 		ResponseEntity<Map<String, String>> registReplyLike1 = likeController.registReplyLike(requestAddReplyLike1);
// 		ResponseEntity<Map<String, String>> registReplyLike2 = likeController.registReplyLike(requestAddReplyLike2);
//
// 		// then
// 		Assertions.assertThat(registReplyLike1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
// 		Assertions.assertThat(registReplyLike2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
// 	}
//
// 	@Test
// 	@DisplayName("회원이 좋아요 누른 게시글 삭제")
// 	void deleteReplyLike() {
//
// 		// given
// 		RequestDeleteReplyLike requestDeleteReplyLike1 =
// 			RequestDeleteReplyLike.builder().replyCode(1).userCode(1).build();
// 		RequestDeleteReplyLike requestDeleteReplyLike2 =
// 			RequestDeleteReplyLike.builder().replyCode(50).userCode(39).build();
//
// 		// when
// 		ResponseEntity<Map<String, String>> response1 = likeController.deleteReplyLike(requestDeleteReplyLike1);
// 		ResponseEntity<Map<String, String>> response2 = likeController.deleteReplyLike(requestDeleteReplyLike2);
//
// 		// then
// 		Assertions.assertThat(HttpStatus.OK).isEqualTo(response1.getStatusCode());
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(response2.getStatusCode());
//
// 	}
// }