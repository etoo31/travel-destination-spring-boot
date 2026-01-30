package com.traveldestination.planner.common.respository.facade;

import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.respository.jpa.ApprovedDestinationsRepository;
import jakarta.transaction.Transactional;
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

    public void saveAll(List<ApprovedDestinationsEntity> entities) {
        try{
            repository.saveAll(entities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save ApprovedDestinationsEntity", e);
        }
    }

    @Transactional
    public void deleteByCountry(String country) {
        try {
            repository.deleteByCountry(country);

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete approved destination for country: " + country, e);
        }
    }

}
