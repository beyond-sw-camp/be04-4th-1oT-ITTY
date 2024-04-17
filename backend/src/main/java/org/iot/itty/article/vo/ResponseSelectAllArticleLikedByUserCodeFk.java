package org.iot.itty.article.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseSelectAllArticleLikedByUserCodeFk {
	private int articleCodePk;
	private String articleTitle;
	private String articleContent;
	private Date articleCreatedDate;
	private Date articleLastUpdatedDate;
	private int userCodeFk;
	private int articleCategory;
	private int articleViewCount;
}
