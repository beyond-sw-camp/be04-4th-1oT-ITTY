package org.iot.itty.article.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iot.itty.article.service.LikeService;
import org.iot.itty.article.vo.RequestAddArticleLike;
import org.iot.itty.article.vo.RequestAddReplyLike;
import org.iot.itty.article.vo.RequestDeleteArticleLike;
import org.iot.itty.article.vo.RequestDeleteReplyLike;
import org.iot.itty.article.vo.ResponseSelectAllArticleLikedByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllReplyLikedByUserCodeFk;
import org.iot.itty.dto.ArticleDTO;
import org.iot.itty.dto.ArticleLikeDTO;
import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.dto.ReplyLikeDTO;
import org.modelmapper.ModelMapper;
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
public class LikeController {

	private final ModelMapper modelMapper;
	private final LikeService likeService;

	@Autowired
	public LikeController(ModelMapper modelMapper, LikeService likeService) {
		this.modelMapper = modelMapper;
		this.likeService = likeService;
	}

	/* 회원이 좋아요 누른 게시글 리스트, 댓글 리스트 조회 */
	@GetMapping("/user/{userCodeFk}/likes")
	public ResponseEntity<Map<String, Object>> selectAllLikeByUserCodeFk(@PathVariable("userCodeFk") int userCodeFk) {

		/* 해당 회원이 좋아요를 누른 댓글 리스트 가져오기 */
		List<ReplyDTO> replyDTOList = likeService.selectAllLikeByUserCodeFk(userCodeFk);

		/* 해당 회원이 좋아요를 누른 게시글 리스트 가져오기*/
		List<ArticleDTO> articleDTOList = likeService.selectAllArticleLikedbyUserCodeFk(userCodeFk);

		if (!replyDTOList.isEmpty() && !articleDTOList.isEmpty()) {
			List<ResponseSelectAllReplyLikedByUserCodeFk> responseSelectAllReplyLikedByUserCodeFkList;
			List<ResponseSelectAllArticleLikedByUserCodeFk> responseSelectAllArticleLikedByUserCodeFkList;

			Map<String, Object> result = new HashMap<>();

			responseSelectAllReplyLikedByUserCodeFkList = replyDTOList
				.stream()
				.map(ReplyDTO -> modelMapper.map(ReplyDTO, ResponseSelectAllReplyLikedByUserCodeFk.class)).toList();

			responseSelectAllArticleLikedByUserCodeFkList = articleDTOList
				.stream()
				.map(ArticleDTO -> modelMapper.map(ArticleDTO, ResponseSelectAllArticleLikedByUserCodeFk.class))
				.toList();

			result.put("userCode", userCodeFk);
			result.put("likedArticleList", responseSelectAllArticleLikedByUserCodeFkList);
			result.put("likedReplyList", responseSelectAllReplyLikedByUserCodeFkList);

			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/article/bulletin/like")
	public ResponseEntity<Map<String, String>> registArticleLike(
		@RequestBody RequestAddArticleLike requestAddArticleLike) {

		Map<String, String> result = new HashMap<>();

		try {
			ArticleLikeDTO responseArticleLikeDTO = likeService.addArticleLike(requestAddArticleLike);
			result.put("message",
				"added like to article #" + responseArticleLikeDTO.getArticleCodeFk() + " successfully.");
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} catch (Exception e) {
			result.put("message",
				"Failed to add like.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}

	@DeleteMapping("/article/bulletin/like")
	public ResponseEntity<Map<String, String>> deleteArticleLike(
		@RequestBody RequestDeleteArticleLike requestDeleteArticleLike) {
		Map<String, String> result = new HashMap<>();
		String returnedMessage = likeService.deleteArticleLike(requestDeleteArticleLike);

		if(returnedMessage.equals("Successfully deleted like from article.")) {
			result.put("message", returnedMessage);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/reply/like")
	public ResponseEntity<Map<String, String>> registReplyLike(@RequestBody RequestAddReplyLike requestAddReplyLike) {
		Map<String, String> result = new HashMap<>();

		try {
			ReplyLikeDTO responseReplyLikeDTO = likeService.addReplyLike(requestAddReplyLike);
			result.put("message", "Successfully added like to reply #" + responseReplyLikeDTO.getReplyCodeFk());
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} catch (Exception e) {
			result.put("message", "Failed to add like to reply");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}

	@DeleteMapping("/reply/like")
	public ResponseEntity<Map<String, String>> deleteReplyLike(
		@RequestBody RequestDeleteReplyLike requestDeleteReplyLike) {
		String returnedMessage = likeService.deleteReplyLike(requestDeleteReplyLike);

		Map<String, String> result = new HashMap<>();
		if(returnedMessage.equals("Successfully deleted like from reply.")){
			result.put("message", returnedMessage);

			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}