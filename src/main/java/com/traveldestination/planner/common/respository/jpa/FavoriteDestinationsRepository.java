package com.traveldestination.planner.common.respository.jpa;

import com.traveldestination.planner.admin.model.CountryStatsDTO;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteDestinationsRepository
        extends JpaRepository<FavoriteDestinationsEntity, FavoriteDestinationsId> {

    List<FavoriteDestinationsEntity> findByUserId(long userId);

    void deleteByCountry(String country);

    @Query(
            value = """
        SELECT
            country,
            MAX(capital) AS capital,
            MAX(region) AS region,
            MAX(population) AS population,
            MAX(currency) AS currency,
            MAX(flag) AS flag,
            COUNT(*) AS noOfSuggestions
        FROM favorite_destinations
        GROUP BY country
    """,
            nativeQuery = true
    )
    List<CountryStatsDTO> getPendingDestinations();


}
