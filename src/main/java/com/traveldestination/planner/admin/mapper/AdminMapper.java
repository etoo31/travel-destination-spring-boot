package com.traveldestination.planner.admin.mapper;

import com.traveldestination.planner.admin.model.CountryStatsDTO;
import com.traveldestination.planner.admin.model.PendingDestinationResponse;
import com.traveldestination.planner.common.model.Destination;
import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PendingDestinationResponse> mapToPendingDestinationResponseList(List<CountryStatsDTO>countryStatsDTOS) {
        List<PendingDestinationResponse> pendingDestinationResponses = new ArrayList<>();
        for (CountryStatsDTO countryStatsDTO : countryStatsDTOS) {
            pendingDestinationResponses.add(mapToPendingDestinationResponse(countryStatsDTO));
        }
        return pendingDestinationResponses;
    }
    public PendingDestinationResponse mapToPendingDestinationResponse(CountryStatsDTO countryStatsDTO) {
        return PendingDestinationResponse.builder()
                .flagUrl(countryStatsDTO.flag())
                .noOfSuggestions(countryStatsDTO.noOfSuggestions())
                .region(countryStatsDTO.region())
                .country(countryStatsDTO.country())
                .population(countryStatsDTO.population())
                .capital(countryStatsDTO.capital())
                .currency(countryStatsDTO.currency())
                .build();

    }
}
