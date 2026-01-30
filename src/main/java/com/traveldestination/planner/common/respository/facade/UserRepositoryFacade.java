package com.traveldestination.planner.common.respository.facade;


import com.traveldestination.planner.common.model.entity.UserEntity;
import com.traveldestination.planner.common.respository.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryFacade {
    public final UserRepository repository;

    public void save(UserEntity entity) {
        try{
            repository.save(entity);
        } catch (Exception e){
            throw new RuntimeException("Failed to save UserEntity", e);
        }
    }

    public UserEntity findById(Long id) {
        try {
            return repository.findById(id).get();

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve UserEntity for id: " + id, e);
        }
    }
}
