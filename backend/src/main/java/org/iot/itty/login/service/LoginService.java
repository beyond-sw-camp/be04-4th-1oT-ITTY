package org.iot.itty.login.service;

import org.iot.itty.dto.UserDTO;
import org.iot.itty.login.vo.ResponseRegist;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {

	ResponseRegist registUser(UserDTO userDTO);

	/* 토큰 발급을 위한 메소드 */
	UserDTO getUserDetailsByUserEmail(String userEmail);

	UserDTO searchUserEmail(String userEmail);

	boolean withdrawalUser(UserDTO userDTO);

}
