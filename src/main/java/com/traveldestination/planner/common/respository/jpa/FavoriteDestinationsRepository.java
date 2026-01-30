package com.traveldestination.planner.common.respository.jpa;

import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteDestinationsRepository
        extends JpaRepository<FavoriteDestinationsEntity, FavoriteDestinationsId> {

    List<FavoriteDestinationsEntity> findByUserId(long userId);

    void deleteByCountry(String country);


}
