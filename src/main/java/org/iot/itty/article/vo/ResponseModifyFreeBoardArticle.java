package org.iot.itty.article.vo;

import java.util.Date;
import java.util.List;

import org.iot.itty.dto.ReplyDTO;

import lombok.Data;

@Data
public class ResponseModifyFreeBoardArticle {
	private int articleCodePk;
	private String articleTitle;
	private String articleContent;
	private Date articleCreatedDate;
	private Date articleLastUpdatedDate;
	private int userCodeFk;
	private int articleCategory;
	private int articleViewCount;
	private List<ReplyDTO> replyDTOList;
}
