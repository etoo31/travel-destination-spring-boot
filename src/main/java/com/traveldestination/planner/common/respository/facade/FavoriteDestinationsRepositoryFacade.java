package com.traveldestination.planner.common.respository.facade;

import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import com.traveldestination.planner.common.respository.jpa.FavoriteDestinationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FavoriteDestinationsRepositoryFacade {
    private final FavoriteDestinationsRepository repository;

    public void save(FavoriteDestinationsEntity entity) {
        try{
            repository.save(entity);
        } catch (Exception e){
            throw new RuntimeException("Failed to save FavoriteDestinationsEntity", e);
        }
    }
    public List<FavoriteDestinationsEntity> findByUserId(Long userId) {
        try {
            return repository.findByUserId(userId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve favorite destinations for user ID: " + userId, e);
        }
    }

    public void deleteByCountry(String country) {
        try {
            repository.deleteByCountry(country);

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete favorite destination for country: " + country, e);
        }
    }

    public void deleteAll(List<FavoriteDestinationsEntity> entities) {
        try {
            repository.deleteAll(entities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete favorite destinations", e);
        }
    }

    public void saveAll(List<FavoriteDestinationsEntity> entities) {
        try {
            repository.saveAll(entities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save favorite destinations", e);
        }
    }
}
