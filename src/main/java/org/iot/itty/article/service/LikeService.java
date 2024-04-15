package org.iot.itty.article.service;

import java.util.List;

import org.iot.itty.article.vo.RequestAddArticleLike;
import org.iot.itty.article.vo.RequestAddReplyLike;
import org.iot.itty.article.vo.RequestDeleteArticleLike;
import org.iot.itty.article.vo.RequestDeleteReplyLike;
import org.iot.itty.dto.ArticleDTO;
import org.iot.itty.dto.ArticleLikeDTO;
import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.dto.ReplyLikeDTO;

public interface LikeService {
	List<ReplyDTO> selectAllLikeByUserCodeFk(int userCodeFk);

	List<ArticleDTO> selectAllArticleLikedbyUserCodeFk(int userCodeFk);

	ArticleLikeDTO addArticleLike(RequestAddArticleLike requestAddArticleLike);

	String deleteArticleLike(RequestDeleteArticleLike requestDeleteArticleLike);

	ReplyLikeDTO addReplyLike(RequestAddReplyLike requestAddReplyLike);

	String deleteReplyLike(RequestDeleteReplyLike requestDeleteReplyLike);
}
