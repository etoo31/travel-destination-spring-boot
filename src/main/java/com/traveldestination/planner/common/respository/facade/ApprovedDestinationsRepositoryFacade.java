package com.traveldestination.planner.common.respository.facade;

import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.respository.jpa.ApprovedDestinationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ApprovedDestinationsRepositoryFacade {

    public final ApprovedDestinationsRepository repository;

    public List<ApprovedDestinationsEntity> findAll() {
        try {
            return repository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve ApprovedDestinationsEntity list", e);
        }
    }

    public void save(ApprovedDestinationsEntity entity) {
        try{
            repository.save(entity);
        } catch (Exception e){
            throw new RuntimeException("Failed to save ApprovedDestinationsEntity", e);
        }
    }

}
