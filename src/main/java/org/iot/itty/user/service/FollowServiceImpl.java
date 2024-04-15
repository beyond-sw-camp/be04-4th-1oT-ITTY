package org.iot.itty.user.service;

import java.util.List;

import org.iot.itty.dto.FollowDTO;
import org.iot.itty.user.aggregate.FollowEntity;
import org.iot.itty.user.repository.FollowRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService{

	private ModelMapper modelMapper;
	private FollowRepository followRepository;

	@Autowired
	public FollowServiceImpl(ModelMapper modelMapper, FollowRepository followRepository) {
		this.modelMapper = modelMapper;
		this.followRepository = followRepository;
	}

	@Override
	public List<FollowDTO> selectAllFollower(int userCodePk) {
		List<FollowEntity> followerEntityList = followRepository.findAllByFollowerCodeFk(userCodePk);

		return followerEntityList
			.stream()
			.map(FollowEntity -> modelMapper.map(FollowEntity, FollowDTO.class))
			.toList();
	}

	@Override
	public List<FollowDTO> selectAllFollowing(int userCodePk) {
		List<FollowEntity> followingEntityList = followRepository.findAllByFolloweeCodeFk(userCodePk);

		return followingEntityList
			.stream()
			.map(FollowEntity -> modelMapper.map(FollowEntity, FollowDTO.class))
			.toList();
	}

	@Override
	public FollowDTO addFollowing(int userCodePk, int followeeCodeFk) {
		List<FollowEntity> followEntityList = followRepository.findAll();
		for (FollowEntity followEntity : followEntityList) {
			if (followEntity.getFollowerCodeFk() == userCodePk && followEntity.getFolloweeCodeFk() == followeeCodeFk) {
				return null;
			}
		}
		FollowEntity followEntity = new FollowEntity();
		followEntity.setFollowerCodeFk(userCodePk);
		followEntity.setFolloweeCodeFk(followeeCodeFk);

		return modelMapper.map(followRepository.save(followEntity), FollowDTO.class);
	}

	@Override
	public String unFollowing(int userCodePk, int followeeCodeFk) {
		List<FollowEntity> followEntityList = followRepository.findAll();
		for (int i = 0; i < followEntityList.size(); i++) {
			if (followEntityList.get(i).getFollowerCodeFk() == userCodePk && followEntityList.get(i).getFolloweeCodeFk() == followeeCodeFk) {
				followRepository.deleteById(followEntityList.get(i).getFollowCodePk());
				return "언팔 완료";
			}
		}
		return "팔로잉 X";
	}
}
