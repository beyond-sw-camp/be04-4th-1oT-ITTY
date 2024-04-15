package org.iot.itty.dto;

import java.util.Date;
import java.util.List;

import org.iot.itty.article.vo.ResponseReplyOfArticleList;
import org.iot.itty.user.vo.ResponseAuthorOfArticleList;

import lombok.Data;

@Data
public class ArticleDTO {
	private int articleCodePk;
	private String articleTitle;
	private String articleContent;
	private Date articleCreatedDate;
	private Date articleLastUpdatedDate;
	private int userCodeFk;
	private int articleCategory;
	private int articleViewCount;
	private ResponseAuthorOfArticleList authorOfArticle;
	private List<ResponseReplyOfArticleList> summarizedReplyDTOList;
	private List<ReplyDTO> replyDTOList;
}
