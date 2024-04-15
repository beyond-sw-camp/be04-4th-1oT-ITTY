package org.iot.itty.article.controller;

import java.util.ArrayList;
import java.util.List;

import org.iot.itty.article.service.ArticleService;
import org.iot.itty.article.service.ReplyService;
import org.iot.itty.article.vo.RequestDeleteBulletinArticle;
import org.iot.itty.article.vo.RequestModifyFreeBoardArticle;
import org.iot.itty.article.vo.RequestRegistFreeBoardArticle;
import org.iot.itty.article.vo.ResponseArticle;
import org.iot.itty.article.vo.ResponseDeleteFreeBoardArticle;
import org.iot.itty.article.vo.ResponseModifyFreeBoardArticle;
import org.iot.itty.article.vo.ResponseRegistFreeBoardArticle;
import org.iot.itty.article.vo.ResponseReplyOfArticleList;
import org.iot.itty.article.vo.ResponseSelectAllArticleByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllFreeBoardArticle;
import org.iot.itty.dto.ArticleDTO;
import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.user.service.UserService;
import org.iot.itty.user.vo.ResponseAuthorOfArticleList;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ArticleController {


	private final ArticleService articleService;
	private final ReplyService replyService;
	private final UserService userService;
	private final ModelMapper mapper;

	@Autowired
	public ArticleController(ArticleService articleService, ReplyService replyService, UserService userService, ModelMapper mapper) {
		this.articleService = articleService;
		this.replyService = replyService;
		this.userService = userService;
		this.mapper = mapper;
	}

	/* 자유게시판 전체조회 */
	@GetMapping("/article/bulletin")
	public ResponseEntity<List<ResponseSelectAllFreeBoardArticle>> selectAllBulletinArticle() {
		List<ArticleDTO> articleDTOList = articleService.selectAllArticleFromFreeBoard();

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ResponseSelectAllFreeBoardArticle> responseArticleList = new ArrayList<>();

		if (articleDTOList != null) {
			responseArticleList = articleDTOList
				.stream()
				.peek(articleDTO -> articleDTO
					.setSummarizedReplyDTOList(
						replyService.selectReplyByArticleCodeFk(articleDTO.getArticleCodePk())
							.stream()
							.map(ReplyDTO -> mapper.map(ReplyDTO, ResponseReplyOfArticleList.class))
							.toList()
					)
				)
				.peek(articleDTO -> articleDTO
					.setAuthorOfArticle(mapper.map(userService.selectUserByUserCodePk(articleDTO.getUserCodeFk()), ResponseAuthorOfArticleList.class)))
				.map(ArticleDTO -> mapper.map(ArticleDTO, ResponseSelectAllFreeBoardArticle.class))
				.toList();
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseArticleList);

	}

	/* 게시글코드(article_code_pk) 로 자유게시판 게시글 한개 조회 */
	@GetMapping("/article/bulletin/{articleCodePk}")
	public ResponseEntity<ResponseArticle> selectBulletinArticleByArticleCodePk(@PathVariable("articleCodePk") int articleCodePk) {

		try {
			ArticleDTO articleDTO = articleService.selectFreeBoardArticleByArticleCodePk(articleCodePk);
			articleDTO.setReplyDTOList(replyService.selectReplyByArticleCodeFk(articleCodePk));
			// mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(articleDTO, ResponseArticle.class));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/* 회원코드(user_code_fk) 로 회원별 작성된 게시글 조회 */
	@GetMapping("/user/{userCodeFk}/articles")
	public ResponseEntity<List<ResponseSelectAllArticleByUserCodeFk>> selectAllBulletinArticleByUserCodeFk(@PathVariable("userCodeFk") int userCodeFk) {
		List<ArticleDTO> articleDTOList = articleService.selectAllArticleByUserCodeFk(userCodeFk);
		List<ResponseSelectAllArticleByUserCodeFk> responseSelectAllArticleByUserCodeFkList = new ArrayList<>();

		if (!articleDTOList.isEmpty()) {
			responseSelectAllArticleByUserCodeFkList = articleDTOList
				.stream()
				.peek(articleDTO -> articleDTO.setReplyDTOList(replyService.selectReplyByArticleCodeFk(articleDTO.getArticleCodePk())))
				.map(ArticleDTO -> mapper.map(ArticleDTO, ResponseSelectAllArticleByUserCodeFk.class))
				.toList();
			return ResponseEntity.status(HttpStatus.OK).body(responseSelectAllArticleByUserCodeFkList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	/* 자유게시판 게시글 등록 */
	@PostMapping("/article/bulletin")
	public ResponseEntity<ResponseRegistFreeBoardArticle> registBulletinArticle(@RequestBody RequestRegistFreeBoardArticle requestRegistFreeBoardArticle) {
		// mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ArticleDTO requestArticleDTO = mapper.map(requestRegistFreeBoardArticle, ArticleDTO.class);
		ArticleDTO responseArticleDTO = articleService.registFreeBoardArticle(requestArticleDTO);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(mapper.map(responseArticleDTO, ResponseRegistFreeBoardArticle.class));
	}

	/* 자유게시판 게시글 수정 */
	@PutMapping("/article/bulletin")
	public ResponseEntity<ResponseModifyFreeBoardArticle> modifyBulletinArticle(
		@RequestBody RequestModifyFreeBoardArticle requestModifyFreeBoardArticle
	)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ArticleDTO requestArticleDTO = mapper.map(requestModifyFreeBoardArticle, ArticleDTO.class);
		ArticleDTO responseArticleDTO = articleService.modifyFreeBoardArticle(requestArticleDTO);

		responseArticleDTO.setReplyDTOList(replyService.selectReplyByArticleCodeFk(
			requestModifyFreeBoardArticle.getArticleCodePk()
		));

		return ResponseEntity
			.status(HttpStatus.OK)
			.body(mapper.map(responseArticleDTO, ResponseModifyFreeBoardArticle.class));
	}

	/* 자유게시판 게시글 삭제 */
	@DeleteMapping("/article/bulletin")
	public ResponseEntity<ResponseDeleteFreeBoardArticle> deleteBulletinArticle(
		@RequestBody RequestDeleteBulletinArticle requestDeleteBulletinArticle
	)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		String returnedMessage = articleService.deleteFreeBoardArticle(requestDeleteBulletinArticle.getArticleCodePk());

		ResponseDeleteFreeBoardArticle responseDeleteFreeBoardArticle = new ResponseDeleteFreeBoardArticle();
		responseDeleteFreeBoardArticle.setMessage(returnedMessage);

		return ResponseEntity.status(HttpStatus.OK).body(responseDeleteFreeBoardArticle);
	}
}
