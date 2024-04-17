package org.iot.itty.article.vo;

import java.util.Date;
import java.util.List;

import org.iot.itty.dto.ReplyDTO;
import org.iot.itty.user.vo.ResponseAuthorOfArticleList;

import lombok.Data;

@Data
public class ResponseSelectAllFreeBoardArticle {
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
}
