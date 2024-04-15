package org.iot.itty.user.service;

import java.util.List;

import org.iot.itty.dto.FollowDTO;
import org.iot.itty.dto.UserDTO;

public interface UserService {
	UserDTO modifyUser(UserDTO userDTO);

	List<UserDTO> selectAllFollowerUser(List<FollowDTO> followerDTOList);

	List<UserDTO> selectAllFollowingUser(List<FollowDTO> followingDTOList);

	UserDTO selectUserByUserCodePk(int userCodePk);
}
