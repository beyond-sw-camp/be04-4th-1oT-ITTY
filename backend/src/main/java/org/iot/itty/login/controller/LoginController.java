package org.iot.itty.login.controller;

import org.iot.itty.dto.UserDTO;
import org.iot.itty.login.jwt.JwtUtil;
import org.iot.itty.login.service.LoginService;
import org.iot.itty.login.vo.RequestRegist;
import org.iot.itty.login.vo.RequestWithdrawal;
import org.iot.itty.login.vo.ResponseRegist;
import org.iot.itty.login.vo.ResponseWithdrawal;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {
	private final LoginService loginService;
	private final ModelMapper modelMapper;
	private final JwtUtil jwtUtil;

	@Autowired
	public LoginController(LoginService loginService, ModelMapper modelMapper,
		JwtUtil jwtUtil) {
		this.loginService = loginService;
		this.modelMapper = modelMapper;
		this.jwtUtil = jwtUtil;
	}

	@GetMapping("/health_check")
	public String healthCheck() {

		return "check check";
	}

	@PostMapping("/regist")
	public ResponseEntity<ResponseRegist> registUser(@RequestBody RequestRegist requestRegist) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO = modelMapper.map(requestRegist, UserDTO.class);

		ResponseRegist responseRegist = loginService.registUser(userDTO);

		String result = responseRegist.getStatus();

		switch (result) {
			case "이메일 중복":
				System.out.println("result:" + responseRegist);
				return ResponseEntity.status(HttpStatus.CONFLICT).body(responseRegist);
			case "닉네임 중복":
				System.out.println("result:" + responseRegist);
				return ResponseEntity.status(HttpStatus.CONFLICT).body(responseRegist);
			default:
				System.out.println("result:" + responseRegist);
				return ResponseEntity.status(HttpStatus.CREATED).body(responseRegist);
		}
	}

	/* 토큰 검증 실패 시 실행되는 api */
	@GetMapping("/error/unauthorized")
	public ResponseEntity<Void> unauthorized() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	// @PostMapping("/logout")
	// public ResponseEntity<Void> userLogout(HttpServletRequest servletRequest) {
	//
	// 	loginService.userLogout();
	//
	// 	return ResponseEntity.status(HttpStatus.OK).build();
	// }

	@PutMapping("/user/withdrawal")
	public ResponseEntity<ResponseWithdrawal> withdrawalUser(@RequestBody RequestWithdrawal requestWithdrawal) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO = modelMapper.map(requestWithdrawal, UserDTO.class);

		ResponseWithdrawal responseWithdrawal = new ResponseWithdrawal();
		responseWithdrawal.setUserEmail(requestWithdrawal.getUserEmail());

		boolean isWithdrawalSuccessful = loginService.withdrawalUser(userDTO);

		if (isWithdrawalSuccessful) {
			responseWithdrawal.setMessage("회원 탈퇴 완료");

			return ResponseEntity.status(HttpStatus.OK).body(responseWithdrawal);
		} else {
			responseWithdrawal.setMessage("이미 탈퇴한 회원입니다.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseWithdrawal);
		}
	}
}