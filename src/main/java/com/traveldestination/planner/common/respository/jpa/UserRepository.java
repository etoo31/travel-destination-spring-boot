package com.traveldestination.planner.common.respository.jpa;

import com.traveldestination.planner.common.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
