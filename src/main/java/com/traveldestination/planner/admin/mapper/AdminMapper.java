package com.traveldestination.planner.admin.mapper;

import com.traveldestination.planner.common.model.Destination;
import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public ApprovedDestinationsEntity map(Destination destination) {
        return ApprovedDestinationsEntity.builder()
                .country(destination.getCountry())
                .capital(destination.getCapital())
                .flag(destination.getFlagUrl())
                .currency(destination.getCurrency())
                .population(destination.getPopulation())
                .region(destination.getRegion())
                .build();
    }

    public FavoriteDestinationsEntity mapDestinationToFavoriteDestinationsEntity(Destination destination) {
        return FavoriteDestinationsEntity.builder()
                .country(destination.getCountry())
                .capital(destination.getCapital())
                .flag(destination.getFlagUrl())
                .currency(destination.getCurrency())
                .population(destination.getPopulation())
                .region(destination.getRegion())
                .build();
    }
}
