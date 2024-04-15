package org.iot.itty.dto;

import lombok.Data;

@Data
public class FollowDTO {
	private Integer followCodePk;
	private Integer followerCodeFk;
	private Integer followeeCodeFk;
}
