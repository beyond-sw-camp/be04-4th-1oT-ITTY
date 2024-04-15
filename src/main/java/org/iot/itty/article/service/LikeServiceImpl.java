package org.iot.itty.article.service;

import java.util.ArrayList;
import java.util.List;

import org.iot.itty.article.aggregate.ArticleEntity;
import org.iot.itty.article.aggregate.ArticleLikeEntity;
import org.iot.itty.article.aggregate.ReplyLikeEntity;
import org.iot.itty.article.aggregate.ReplyEntity;
import org.iot.itty.article.repository.ArticleLikeRepository;
import org.iot.itty.article.repository.ArticleRepository;
import org.iot.itty.article.repository.ReplyLikeRepository;
import org.iot.itty.article.repository.ReplyRepository;
import org.iot.itty.article.vo.RequestAddArticleLike;
import org.iot.itty.article.vo.RequestAddReplyLike;
import org.iot.itty.article.vo.RequestDeleteArticleLike;
import org.iot.itty.article.vo.RequestDeleteReplyLike;
import org.iot.itty.dto.ArticleDTO;
import org.iot.itty.dto.ArticleLikeDTO;
import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.dto.ReplyLikeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeServiceImpl implements LikeService{

	private final ModelMapper modelMapper;
	private final ReplyLikeRepository replyLikeRepository;
	private final ReplyRepository replyRepository;
	private final ArticleLikeRepository articleLikeRepository;
	private final ArticleRepository articleRepository;

	@Autowired
	public LikeServiceImpl(
		ModelMapper modelMapper,
		ReplyLikeRepository replyLikeRepository,
		ReplyRepository replyRepository,
		ArticleLikeRepository articleLikeRepository,
		ArticleRepository articleRepository
	)
	{
		this.modelMapper = modelMapper;
		this.replyLikeRepository = replyLikeRepository;
		this.replyRepository = replyRepository;
		this.articleLikeRepository = articleLikeRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public List<ReplyDTO> selectAllLikeByUserCodeFk(int userCodeFk) {
		List<ReplyLikeEntity> replyLikeEntityList = replyLikeRepository.findAllByUserCodeFk(userCodeFk);
		List<ReplyDTO> replyDTOList = new ArrayList<>();
		for (ReplyLikeEntity replyLikeEntity : replyLikeEntityList) {
			ReplyEntity replyEntity = replyRepository.findById(replyLikeEntity.getReplyCodeFk()).orElseThrow(IllegalAccessError::new);
			replyDTOList.add(modelMapper.map(replyEntity, ReplyDTO.class));
		}
		return replyDTOList;
	}

	@Override
	public List<ArticleDTO> selectAllArticleLikedbyUserCodeFk(int userCodeFk) {
		List<ArticleLikeEntity> articleLikeEntityList = articleLikeRepository.findAllByUserCodeFk(userCodeFk);
		List<ArticleDTO> articleDTOList = new ArrayList<>();
		for (ArticleLikeEntity articleLikeEntity : articleLikeEntityList) {
			ArticleEntity articleEntity = articleRepository.findById(articleLikeEntity.getArticleCodeFk()).orElseThrow(IllegalAccessError::new);
			articleDTOList.add(modelMapper.map(articleEntity, ArticleDTO.class));
		}
		return articleDTOList;
	}

	@Transactional
	@Override
	public ArticleLikeDTO addArticleLike(RequestAddArticleLike requestAddArticleLike) {
		ArticleLikeEntity articleLikeEntity = ArticleLikeEntity.builder()
			.articleCodeFk(requestAddArticleLike.getArticleCode())
			.userCodeFk(requestAddArticleLike.getUserCode())
			.build();
		return modelMapper.map(articleLikeRepository.save(articleLikeEntity), ArticleLikeDTO.class);
	}

	@Transactional
	@Override
	public String deleteArticleLike(RequestDeleteArticleLike requestDeleteArticleLike) {
		try {
			ArticleLikeEntity articleLikeEntity = articleLikeRepository.findByArticleCodeFkAndUserCodeFk(
				requestDeleteArticleLike.getArticleCode(), requestDeleteArticleLike.getUserCode()
			);
			if (articleLikeEntity != null) {
				articleLikeRepository.deleteById(articleLikeEntity.getArticleLikeCodePk());
				return "Successfully deleted like from article.";
			} else {
				return "Error: the like you want to delete does not exist.";
			}

		} catch (Exception e) {
			return "Error: failed to delete like from article.\n" + e.getMessage();
		}
	}

	@Transactional
	@Override
	public ReplyLikeDTO addReplyLike(RequestAddReplyLike requestAddReplyLike) {
		ReplyLikeEntity replyLikeEntity = ReplyLikeEntity.builder()
			.userCodeFk(requestAddReplyLike.getUserCode())
			.replyCodeFk(requestAddReplyLike.getReplyCode())
			.build();
		return modelMapper.map(replyLikeRepository.save(replyLikeEntity), ReplyLikeDTO.class);
	}

	@Transactional
	@Override
	public String deleteReplyLike(RequestDeleteReplyLike requestDeleteReplyLike) {
		try {
			ReplyLikeEntity replyLikeEntity = replyLikeRepository.findByReplyCodeFkAndUserCodeFk(
				requestDeleteReplyLike.getReplyCode(), requestDeleteReplyLike.getUserCode()
			);
			if (replyLikeEntity != null) {
				replyLikeRepository.deleteById(replyLikeEntity.getLikeCodePk());
				return "Successfully deleted like from reply.";
			} else {
				return "Error: the like you want to delete does not exist.";
			}
		} catch (Exception e) {
			return "Error: failed to delete like from article.\n" + e.getMessage();
		}
	}
}
