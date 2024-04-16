package org.iot.itty.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.iot.itty.dto.FollowDTO;
import org.iot.itty.dto.UserDTO;
import org.iot.itty.user.aggregate.UserEntity;
import org.iot.itty.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
		BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Transactional
	@Override
	public UserDTO modifyUser(UserDTO userDTO) {
		UserEntity user = userRepository.findById(userDTO.getUserCodePk()).orElseThrow(IllegalAccessError::new);
		user.setUserNickname(userDTO.getUserNickname());
		user.setUserIntroduction(userDTO.getUserIntroduction());
		user.setUserName(userDTO.getUserName());
		user.setUserPassword(bCryptPasswordEncoder.encode(userDTO.getUserPassword()));
		user.setUserPhoneNumber(userDTO.getUserPhoneNumber());

		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> selectAllFollowerUser(List<FollowDTO> followerDTOList) {
		List<UserDTO> userDTOList = new ArrayList<>();

		for (int i = 0; i < followerDTOList.size(); i++) {
			userDTOList.add(modelMapper.map(userRepository.findById(followerDTOList.get(i).getFolloweeCodeFk()), UserDTO.class));
		}
		return userDTOList;
	}

	@Override
	public List<UserDTO> selectAllFollowingUser(List<FollowDTO> followingDTOList) {
		List<UserDTO> userDTOList = new ArrayList<>();

		for (int i = 0; i < followingDTOList.size(); i++) {
			userDTOList.add(modelMapper.map(userRepository.findById(followingDTOList.get(i).getFollowerCodeFk()), UserDTO.class));
		}
		return userDTOList;
	}

	@Override
	public UserDTO selectUserByUserCodePk(int userCodePk) {
		UserEntity userEntity = userRepository.findById(userCodePk).orElseThrow(IllegalAccessError::new);

		return modelMapper.map(userEntity, UserDTO.class);
	}
}
