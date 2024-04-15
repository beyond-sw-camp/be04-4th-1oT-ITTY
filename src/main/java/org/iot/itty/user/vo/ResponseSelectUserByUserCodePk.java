package org.iot.itty.user.vo;

import java.util.List;

import org.iot.itty.article.vo.ResponseSelectAllArticleByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllArticleLikedByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllReplyByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllReplyLikedByUserCodeFk;
import org.iot.itty.article.vo.ResponseSelectAllScrapByUserCodeFk;

import lombok.Data;

@Data
public class ResponseSelectUserByUserCodePk {
	private int userCodePk;
	private String userEmail;
	private String userName;
	private String userPhoneNumber;
	private String userRole;
	private String userNickname;
	private String userPassword;
	private String userIntroduction;
	private int userDeleteStatus;
	private List<ResponseSelectAllArticleByUserCodeFk> articleDTOList;
	private List<ResponseSelectAllReplyByUserCodeFk> replyDTOList;
	private List<ResponseSelectAllArticleLikedByUserCodeFk>likedArticleDTOList;
	private List<ResponseSelectAllReplyLikedByUserCodeFk> likedReplyDTOList;
	private List<ResponseSelectAllScrapByUserCodeFk> scrappedTrendArticleDTOList;
}
