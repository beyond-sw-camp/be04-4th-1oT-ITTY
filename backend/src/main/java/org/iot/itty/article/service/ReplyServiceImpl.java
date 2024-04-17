package org.iot.itty.article.service;

import java.util.Date;
import java.util.List;

import org.iot.itty.article.aggregate.ReplyEntity;
import org.iot.itty.article.repository.ReplyRepository;
import org.iot.itty.dto.ReplyDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{

	private final ReplyRepository replyRepository;
	private final ModelMapper mapper;

	@Autowired
	public ReplyServiceImpl(ReplyRepository replyRepository, ModelMapper mapper) {
		this.replyRepository = replyRepository;
		this.mapper = mapper;
	}

	@Override
	public List<ReplyDTO> selectReplyByArticleCodeFk(int articleCodePk) {
		List<ReplyEntity> replyEntityList = replyRepository.findAllByArticleCodeFk(articleCodePk);

		return replyEntityList
			.stream()
			.map(ReplyEntity -> mapper.map(ReplyEntity, ReplyDTO.class))
			.toList();
	}

	@Override
	public List<ReplyDTO> selectAllReplyByUserCodeFk(int userCodeFk) {
		List<ReplyEntity> replyEntityList = replyRepository.findAllByUserCodeFk(userCodeFk);

		return replyEntityList
			.stream()
			.map(ReplyEntity -> mapper.map(ReplyEntity, ReplyDTO.class))
			.toList();
	}

	@Transactional
	@Override
	public ReplyDTO registReply(ReplyDTO requestReplyDTO) {
		ReplyEntity replyEntity = ReplyEntity.builder()
			.replyContent(requestReplyDTO.getReplyContent())
			.userCodeFk(requestReplyDTO.getUserCodeFk())
			.articleCodeFk(requestReplyDTO.getArticleCodeFk())
			.replyCreatedDate(new Date())
			.replyLastUpdatedDate(new Date())
			.build();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(replyRepository.save(replyEntity), ReplyDTO.class);
	}

	@Override
	public ReplyDTO modifyReply(ReplyDTO requestReplyDTO, int replyCodePk) {
		ReplyEntity foundReplyEntity = replyRepository.findById(replyCodePk).get();

		if (requestReplyDTO.getUserCodeFk() == foundReplyEntity.getUserCodeFk()
			&& requestReplyDTO.getArticleCodeFk() == foundReplyEntity.getArticleCodeFk()) {

			ReplyEntity replyEntity = ReplyEntity.builder()
				.replyCodePk(replyCodePk)
				.replyContent(requestReplyDTO.getReplyContent())
				.userCodeFk(requestReplyDTO.getUserCodeFk())
				.articleCodeFk(requestReplyDTO.getArticleCodeFk())
				.replyCreatedDate(foundReplyEntity.getReplyCreatedDate())
				.replyLastUpdatedDate(new Date())
				.build();
			return mapper.map(replyRepository.save(replyEntity), ReplyDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public String deleteReply(int replyCodePk) {
		String message;
		if(!replyRepository.findById(replyCodePk).isEmpty()) {
			replyRepository.deleteById(replyCodePk);
			message = "Deleted reply #" + replyCodePk + " successfully.";
			return message;
		}

		return "No Reply Exists";
	}
}
