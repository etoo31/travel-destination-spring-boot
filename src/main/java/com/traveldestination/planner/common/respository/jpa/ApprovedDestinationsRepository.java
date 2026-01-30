package com.traveldestination.planner.common.respository.jpa;

import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedDestinationsRepository extends JpaRepository<ApprovedDestinationsEntity, Long> {

     void deleteByCountry(String country);
}
