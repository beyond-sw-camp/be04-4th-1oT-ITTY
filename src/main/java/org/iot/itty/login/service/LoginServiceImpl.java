package org.iot.itty.login.service;

import java.util.ArrayList;

import org.apache.coyote.Response;
import org.iot.itty.dto.UserDTO;
import org.iot.itty.login.redis.RedisConfig;
import org.iot.itty.login.redis.TokenRepository;
import org.iot.itty.login.vo.ResponseRegist;
import org.iot.itty.user.aggregate.UserEntity;
import org.iot.itty.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
	private final UserRepository userRepository;
	public final BCryptPasswordEncoder bCryptPasswordEncoder;
	public final RedisConfig redisConfig;
	public final RedisTemplate redisTemplate;
	public final TokenRepository tokenRepository;

	public LoginServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
		RedisConfig redisConfig, RedisTemplate redisTemplate,
		TokenRepository tokenRepository) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.redisConfig = redisConfig;
		this.redisTemplate = redisTemplate;
		this.tokenRepository = tokenRepository;
	}

	/* 회원 가입 */
	@Override
	public ResponseRegist registUser(UserDTO userDTO) {

		String userEmail = userDTO.getUserEmail();
		String userPassword = userDTO.getUserPassword();
		String userName = userDTO.getUserName();
		String userPhoneNumber = userDTO.getUserPhoneNumber();
		String userNickname = userDTO.getUserNickname();

		// 아이디 중복 체크
		boolean isEmailExists = userRepository.existsByUserEmail(userEmail);

		// 닉네임 중복 체크
		boolean isNickNameExists = userRepository.existsByUserNickname(userNickname);
		System.out.println("닉네임 중복체크: " + isNickNameExists);

		ResponseRegist responseRegist = new ResponseRegist();

		if (isEmailExists) {
			responseRegist.setStatus("이메일 중복");
			responseRegist.setMessage("'" + userEmail + "' 는(은) 이미 존재하는 사용자 입니다.");

			return responseRegist;
		}

		if (isNickNameExists) {
			responseRegist.setStatus("닉네임 중복");
			responseRegist.setMessage("이미 사용 중인 닉네임 입니다.");

			return responseRegist;
		}

		UserEntity data = new UserEntity();

		data.setUserEmail(userEmail);
		data.setUserPassword(bCryptPasswordEncoder.encode(userPassword));
		data.setUserName(userName);
		data.setUserPhoneNumber(userPhoneNumber);
		data.setUserNickname(userNickname);
		data.setUserRole("USER");
		data.setUserDeleteStatus(0);
		data.setUserIntroduction("내 소개가 아직 없습니다.");

		userRepository.save(data);

		responseRegist.setUserCodePk(data.getUserCodePk());
		responseRegist.setUserEmail(userEmail);
		responseRegist.setStatus("가입 성공");
		responseRegist.setMessage("회원 가입 성공");

		return responseRegist;
	}

	/* 회원 탈퇴 */
	@Override
	public boolean withdrawalUser(UserDTO userDTO) {

		boolean isWithdrawalSuccessful = true;

		String inputUserPassword = userDTO.getUserPassword();

		UserEntity user = userRepository.findByUserEmail(userDTO.getUserEmail());

		boolean isVaildateUserPassword = validatePassword(user, inputUserPassword);

		if (user != null) {
			if (isVaildateUserPassword) {
				log.info("비밀번호 일치");

				if (user.getUserDeleteStatus() != 1) {

					user.setUserDeleteStatus(1);

					userRepository.save(user);

					return isWithdrawalSuccessful;
				}
			} else {
				throw new IllegalAccessError("비밀번호가 일치하지 않습니다.");
			}
		} else {
			// return ResponseEntity.badRequest().build().hasBody();
			throw new IllegalAccessError("'" + userDTO.getUserEmail() + "' 해당 유저를 찾을 수 없습니다.");
		}

		return !isWithdrawalSuccessful;
	}

	/* 비밀번호 유효성 검사 */
	private boolean validatePassword(UserEntity user, String inputUserPassword) {
		String userPassword = user.getUserPassword();

		if (bCryptPasswordEncoder.matches(inputUserPassword, userPassword)) {
			return true;
		} else {
			return false;
		}
	}

	/* DB에서 유저 정보를 가져와 입력된 정보와 비교할 User 객체 생성 */
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUserEmail(userEmail);

		if (userEntity == null) {
			throw new UsernameNotFoundException("'" + userEmail + "' 해당 유저는 존재하지 않습니다.");
		}

		return new User(userEntity.getUserEmail(), userEntity.getUserPassword(),
			true, true, true, true,
			new ArrayList<>());
	}

	/* 유저 이메일 조회하여 해당 유저 정보 반환(토큰 발급용) */
	@Override
	public UserDTO getUserDetailsByUserEmail(String userEmail) {
		UserEntity userEntity = userRepository.findByUserEmail(userEmail);

		if (userEntity == null)
			throw new UsernameNotFoundException(userEmail);

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDTO userDTO = mapper.map(userEntity, UserDTO.class);

		return userDTO;
	}

	@Override
	public UserDTO searchUserEmail(String userEmail) {
		UserEntity userEntity = userRepository.findByUserEmail(userEmail);

		ModelMapper mapper = new ModelMapper();
		UserDTO userDTO = mapper.map(userEntity, UserDTO.class);

		return userDTO;
	}
}