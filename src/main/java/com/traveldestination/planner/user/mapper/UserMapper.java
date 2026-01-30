package com.traveldestination.planner.user.mapper;

import com.traveldestination.planner.client.RestCountryResponse;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import com.traveldestination.planner.user.model.request.ManageFavoriteDestinationRequest;
import com.traveldestination.planner.common.model.Destination;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class UserMapper {
    public Destination map(RestCountryResponse source) {
        if (source == null) {
            return null;
        }

        return Destination.builder()
                .country(source.getName() != null ? source.getName().getCommon() : null)
                .capital(getCapital(source.getCapital()))
                .region(source.getRegion())
                .population(source.getPopulation())
                .currency(getCurrency(source.getCurrencies()))
                .flagUrl(source.getFlags() != null ? source.getFlags().getSvg() : null)
                .build();
    }
    public List<Destination> map(List<RestCountryResponse> source) {
        return source.stream().map(this::map).toList();
    }

    private String getCurrency(Map<String, RestCountryResponse.Currency> currencies) {
        if (currencies != null && !currencies.isEmpty()) {
            return currencies.values().iterator().next().getName();
        }
        return null;
    }

    private String getCapital(List<String> capitalList) {
        if (capitalList != null && !capitalList.isEmpty()) {
            return capitalList.get(0);
        }
        return null;
    }

    public FavoriteDestinationsEntity map(long userId, ManageFavoriteDestinationRequest request) {
        if (request == null) {
            return null;
        }
        return FavoriteDestinationsEntity.builder()
                .userId(userId)
                .flag(request.getFlagUrl())
                .capital(request.getCapital())
                .country(request.getCountry())
                .currency(request.getCurrency())
                .population(request.getPopulation())
                .region(request.getRegion())
                .build();
    }



}
