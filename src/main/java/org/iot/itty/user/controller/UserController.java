package org.iot.itty.user.controller;

import java.util.List;

import org.iot.itty.article.service.ArticleService;
import org.iot.itty.article.service.LikeService;
import org.iot.itty.article.service.ReplyService;
import org.iot.itty.article.service.ScrapService;
import org.iot.itty.article.vo.ResponseSelectAllArticleByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllArticleLikedByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllReplyByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllReplyLikedByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllScrapByUserCodeFk;
import org.iot.itty.dto.ArticleDTO;
import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.dto.TrendArticleDTO;
import org.iot.itty.dto.UserDTO;
import org.iot.itty.user.service.UserService;
import org.iot.itty.user.vo.RequestUserModify;
import org.iot.itty.user.vo.ResponseSelectUserByUserCodePk;
import org.iot.itty.user.vo.ResponseUserModify;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	private final ModelMapper modelMapper;
	private final UserService userService;
	private final ArticleService articleService;
	private final ReplyService replyService;
	private final LikeService likeService;
	private final ScrapService scrapService;

	@Autowired
	public UserController(
		ModelMapper modelMapper,
		UserService userService,
		ArticleService articleService,
		ReplyService replyService,
		LikeService likeService,
		ScrapService scrapService
	)
	{
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.articleService = articleService;
		this.replyService = replyService;
		this.likeService = likeService;
		this.scrapService = scrapService;
	}

	/* 회원별 회원정보 조회 */
	@GetMapping("/user/{userCodePk}")
	public ResponseEntity<ResponseSelectUserByUserCodePk> selectUserByUserCodePk(@PathVariable("userCodePk") int userCodePk) {
		UserDTO userDTO = userService.selectUserByUserCodePk(userCodePk);

		/* 해당 회원이 작성한 게시글 리스트 가져오기 */
		List<ResponseSelectAllArticleByUserCodeFk> responseSelectAllArticleByUserCodeFkList =
			articleService.selectAllArticleByUserCodeFk(userCodePk)
				.stream()
				.map(ArticleDTO -> modelMapper.map(ArticleDTO, ResponseSelectAllArticleByUserCodeFk.class))
				.toList();

		/* 해당 회원이 작성한 댓글 리스트 가져오기 */
		List<ResponseSelectAllReplyByUserCodeFk> responseSelectAllReplyByUserCodeFkList =
			replyService.selectAllReplyByUserCodeFk(userCodePk)
				.stream()
				.map(ReplyDTO -> modelMapper.map(ReplyDTO, ResponseSelectAllReplyByUserCodeFk.class))
				.toList();

		/* 해당 회원이 좋아요 누른 게시글 리스트 가져오기 */
		List<ResponseSelectAllArticleLikedByUserCodeFk> responseSelectAllArticleLikedByUserCodeFkList =
			likeService.selectAllArticleLikedbyUserCodeFk(userCodePk)
				.stream()
				.map(ArticleDTO -> modelMapper.map(ArticleDTO, ResponseSelectAllArticleLikedByUserCodeFk.class))
				.toList();

		/* 해당 회원이 좋아요 누른 댓글 리스트 가져오기 */
		List<ResponseSelectAllReplyLikedByUserCodeFk> responseSelectAllReplyLikedByUserCodeFkList =
			likeService.selectAllLikeByUserCodeFk(userCodePk)
				.stream()
				.map(ReplyDTO -> modelMapper.map(ReplyDTO, ResponseSelectAllReplyLikedByUserCodeFk.class))
				.toList();

		/* 해당 회원이 스크랩한 트렌드 게시글 리스트 가져오기 */
		List<ResponseSelectAllScrapByUserCodeFk> responseSelectAllScrapByUserCodeFkList =
			scrapService.selectAllScrapByUserCodeFk(userCodePk)
				.stream()
				.map(TrendArticleDTO -> modelMapper.map(TrendArticleDTO, ResponseSelectAllScrapByUserCodeFk.class))
				.toList();

		userDTO.setArticleDTOList(responseSelectAllArticleByUserCodeFkList);
		userDTO.setReplyDTOList(responseSelectAllReplyByUserCodeFkList);
		userDTO.setLikedArticleDTOList(responseSelectAllArticleLikedByUserCodeFkList);
		userDTO.setLikedReplyDTOList(responseSelectAllReplyLikedByUserCodeFkList);
		userDTO.setScrappedTrendArticleDTOList(responseSelectAllScrapByUserCodeFkList);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(userDTO, ResponseSelectUserByUserCodePk.class));
	}

	/* 회원정보 수정 */
	@PostMapping("/user/modify")
	public ResponseEntity<ResponseUserModify> modifyUser(@RequestBody RequestUserModify modifyUserData){

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO = modelMapper.map(modifyUserData, UserDTO.class);
		UserDTO user = userService.modifyUser(userDTO);

		ResponseUserModify responseUser = new ResponseUserModify();

		if(user == null) {
			responseUser.setResultCode(400); // 예시 코드, 실제 애플리케이션에 맞게 조정해야 함
			responseUser.setMessage("사용자 정보를 찾을 수 없습니다.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseUser);
		}

		if(user.getUserCodePk() == userDTO.getUserCodePk()){
			if(user.getUserNickname().equals(userDTO.getUserNickname()) && user.getUserIntroduction().equals(userDTO.getUserIntroduction())) {
				responseUser.setResultCode(200);
				responseUser.setMessage("프로필 수정 완료 되었습니다.");
			}
		}
		else{
			responseUser.setResultCode(200);
			responseUser.setMessage("비밀번호 확인 바랍니다.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseUser);
	}
}
