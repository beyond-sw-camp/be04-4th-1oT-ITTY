package org.iot.itty.user.repository;

import java.util.List;

import org.iot.itty.user.aggregate.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<FollowEntity, Integer> {
	List<FollowEntity> findAllByFollowerCodeFk(int userCodePk);

	List<FollowEntity> findAllByFolloweeCodeFk(int userCodePk);
}
