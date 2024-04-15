// package org.iot.itty.user.controller;
//
// import org.iot.itty.user.service.UserService;
// import org.iot.itty.user.vo.RequestUserModify;
// import org.iot.itty.dto.UserDTO;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.BDDMockito.given;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
//
// @SpringBootTest
// @AutoConfigureMockMvc
// public class UserControllerTests {
//
// 	@Autowired
// 	private MockMvc mockMvc;
//
// 	@MockBean
// 	private UserService userService;
//
// 	@DisplayName("User 정보 수정")
// 	@Test
// 	void modifyUser() throws Exception {
// 		// given
// 		RequestUserModify requestUserModify = new RequestUserModify();
// 		requestUserModify.setUserCodePk(3); // 주의: 실제 유저 PK와 일치해야 합니다.
// 		requestUserModify.setUserNickname("테스트");
// 		requestUserModify.setUserIntroduction("수정 테스트");
//
// 		UserDTO mockUserDto = new UserDTO();
// 		mockUserDto.setUserCodePk(requestUserModify.getUserCodePk());
// 		mockUserDto.setUserNickname(requestUserModify.getUserNickname());
// 		mockUserDto.setUserIntroduction(requestUserModify.getUserIntroduction());
//
// 		// UserService의 modifyUser 메서드가 mockUserDto를 반환하도록 설정
// 		given(userService.modifyUser(any(UserDTO.class))).willReturn(mockUserDto);
//
// 		// ObjectMapper를 사용하여 RequestUserModify 객체를 JSON 문자열로 변환
// 		ObjectMapper objectMapper = new ObjectMapper();
// 		String jsonContent = objectMapper.writeValueAsString(requestUserModify);
//
// 		// when & then
// 		mockMvc.perform(post("/user/modify")
// 				.contentType(MediaType.APPLICATION_JSON)
// 				.content(jsonContent))
// 			.andExpect(status().isOk()) // 상태 코드 검증
// 			.andExpect(jsonPath("$.resultCode").value(200))
// 			.andExpect(jsonPath("$.message").value("프로필 수정 완료 되었습니다."));
// 	}
// }
