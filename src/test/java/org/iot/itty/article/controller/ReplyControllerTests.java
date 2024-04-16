package org.iot.itty.article.controller;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.iot.itty.article.vo.RequestDeleteReply;
import org.iot.itty.article.vo.RequestModifyReply;
import org.iot.itty.article.vo.RequestRegistReply;
import org.iot.itty.article.vo.ResponseRegistReply;
import org.iot.itty.article.vo.ResponseSelectAllReplyByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectReplyByArticleCodeFk;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
@Transactional
class ReplyControllerTests {

	@Autowired
	private ReplyController replyController;

	@Test
	@DisplayName("자유게시판 모든 댓글 조회 테스트")
	void selectAllReplyByBulletinArticleCodeFk() {

		// given
		int articleCodeFk1 = 1;
		int articleCodeFk2 = 50;

		// when
		ResponseEntity<List<ResponseSelectReplyByArticleCodeFk>> response1 = replyController.selectAllReplyByBulletinArticleCodeFk(articleCodeFk1);
		ResponseEntity<List<ResponseSelectReplyByArticleCodeFk>> response2 = replyController.selectAllReplyByBulletinArticleCodeFk(articleCodeFk2);

		// then
		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	@DisplayName("사용자가 작성한 모든 댓글 조회 테스트")
	void selectAllReplyByUserCodeFk() {
		// given
		int userCodeFk1 = 1;
		int userCodeFk2 = 50;

		// when
		ResponseEntity<List<ResponseSelectAllReplyByUserCodeFk>> response1 = replyController.selectAllReplyByUserCodeFk(userCodeFk1);
		ResponseEntity<List<ResponseSelectAllReplyByUserCodeFk>> response2 = replyController.selectAllReplyByUserCodeFk(userCodeFk2);

		// then
		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	@DisplayName("댓글 작성 테스트")
	void registReply() {

		// given
		RequestRegistReply requestRegistReply1 = RequestRegistReply.builder()
			.replyContent("Reply 1").articleCodeFk(1).userCodeFk(1).build();
		RequestRegistReply requestRegistReply2 = RequestRegistReply.builder()
			.replyContent("asdfasf").articleCodeFk(123).userCodeFk(123).build();

		// when
		ResponseEntity<ResponseRegistReply> response1 = replyController.registReply(requestRegistReply1);
		ResponseEntity<ResponseRegistReply> response2 = replyController.registReply(requestRegistReply2);

		// then
		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	@DisplayName("댓글 수정 테스트")
	void modifyReply() {

		// given
		RequestModifyReply requestModifyReply1 = RequestModifyReply.builder().
			replyContent("asdfasdf").articleCodeFk(1).userCodeFk(1).build();
		int replyCodePk1 = 1;
		RequestModifyReply requestModifyReply2 = RequestModifyReply.builder().
			replyContent("asdfsadfg").articleCodeFk(333).userCodeFk(1111).build();
		int replyCodePk2 = 30;

		// when
		ResponseEntity<Map<String, String>> response1 = replyController.modifyReply(requestModifyReply1, replyCodePk1);
		ResponseEntity<Map<String, String>> response2 = replyController.modifyReply(requestModifyReply2, replyCodePk2);

		// then
		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	@DisplayName("댓글 삭제 테스트")
	void deleteReply() {

		// given
		RequestDeleteReply requestDeleteReply1 = RequestDeleteReply.builder().replyCodePk(3).build();
		RequestDeleteReply requestDeleteReply2 = RequestDeleteReply.builder().replyCodePk(123).build();

		// when
		ResponseEntity<Map<String, String>> response1 = replyController.deleteReply(requestDeleteReply1);
		ResponseEntity<Map<String, String>> response2 = replyController.deleteReply(requestDeleteReply2);

		// then
		Assertions.assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}