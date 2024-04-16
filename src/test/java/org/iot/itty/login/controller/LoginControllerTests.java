// package org.iot.itty.login.controller;
//
// import org.assertj.core.api.Assertions;
// import org.iot.itty.login.vo.RequestRegist;
// import org.iot.itty.login.vo.RequestWithdrawal;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.transaction.annotation.Transactional;
//
// @ExtendWith(MockitoExtension.class)
// @SpringBootTest
// @AutoConfigureMockMvc
// @Transactional
// public class LoginControllerTests {
//
// 	@Autowired
// 	private LoginController loginController;
//
// 	@Test
// 	@DisplayName("회원 가입 성공 테스트")
// 	public void testRegistUser_Success() {
// 		// given(DB에 존재하지 않는 값으로 입력)
// 		RequestRegist requestRegist = new RequestRegist();
// 		requestRegist.setUserEmail("test001@example.com");
// 		requestRegist.setUserPassword("password");
// 		requestRegist.setUserName("testName");
// 		requestRegist.setUserNickname("nickName");
// 		requestRegist.setUserPhoneNumber("123456789");
//
// 		// When
// 		HttpStatusCode result = loginController.registUser(requestRegist).getStatusCode();
//
// 		// Then
// 		Assertions.assertThat(HttpStatus.CREATED).isEqualTo(result);
// 	}
//
// 	@Test
// 	@DisplayName("회원 가입 실패 테스트")
// 	public void testRegistUser_Fail() {
// 		// given(DB에 존재하는 값으로 입력)
// 		// 이메일 중복
// 		RequestRegist requestRegist = new RequestRegist();
// 		requestRegist.setUserEmail("user3@example.com");
// 		requestRegist.setUserPassword("password3");
// 		requestRegist.setUserName("user3");
// 		requestRegist.setUserNickname("none");
// 		requestRegist.setUserPhoneNumber("555555555");
//
// 		// 닉네임 중복
// 		RequestRegist requestRegist2 = new RequestRegist();
// 		requestRegist2.setUserEmail("none@example.com");
// 		requestRegist2.setUserPassword("password3");
// 		requestRegist2.setUserName("user3");
// 		requestRegist2.setUserNickname("test");
// 		requestRegist2.setUserPhoneNumber("555555555");
//
// 		// When
// 		HttpStatusCode result = loginController.registUser(requestRegist).getStatusCode();
// 		HttpStatusCode result2 = loginController.registUser(requestRegist2).getStatusCode();
//
// 		// Then
// 		Assertions.assertThat(HttpStatus.CONFLICT).isEqualTo(result);
// 		Assertions.assertThat(HttpStatus.CONFLICT).isEqualTo(result2);
// 	}
//
// 	@Test
// 	@DisplayName("회원 탈퇴 테스트")
// 	public void testWithdrawalUser() {
//
// 		// given(user_delete_status가 0인 회원)
// 		// 회원 탈퇴 성공 시
// 		RequestWithdrawal requestWithdrawal = new RequestWithdrawal();
// 		requestWithdrawal.setUserEmail("test023@example.com");
// 		requestWithdrawal.setUserPassword("test");
//
// 		// 회원 탈퇴 실패 시
// 		RequestWithdrawal requestWithdrawal2 = new RequestWithdrawal();
// 		requestWithdrawal2.setUserEmail("test022@example.com");
// 		requestWithdrawal2.setUserPassword("test");
//
// 		// when
// 		HttpStatusCode result = loginController.withdrawalUser(requestWithdrawal).getStatusCode();
// 		HttpStatusCode result2 = loginController.withdrawalUser(requestWithdrawal2).getStatusCode();
//
// 		// then
// 		Assertions.assertThat(HttpStatus.OK).isEqualTo(result);
// 		Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo(result2);
// 	}
// }
