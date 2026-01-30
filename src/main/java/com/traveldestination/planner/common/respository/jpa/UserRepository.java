package com.traveldestination.planner.common.respository.jpa;

import com.traveldestination.planner.common.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
        Optional<UserEntity> findFirstByUsername(String userName);

}
