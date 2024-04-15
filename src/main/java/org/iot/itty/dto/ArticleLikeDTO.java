package org.iot.itty.dto;

import lombok.Data;

@Data
public class ArticleLikeDTO {
	private int articleLikeCodePk;
	private int articleCodeFk;
	private int userCodeFk;
}
