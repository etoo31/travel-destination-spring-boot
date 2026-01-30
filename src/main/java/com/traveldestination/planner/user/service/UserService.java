package com.traveldestination.planner.user.service;

import com.traveldestination.planner.client.RestCountriesClientFacade;
import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.model.entity.FavoriteDestinationsEntity;
import com.traveldestination.planner.common.respository.facade.ApprovedDestinationsRepositoryFacade;
import com.traveldestination.planner.common.respository.facade.FavoriteDestinationsRepositoryFacade;
import com.traveldestination.planner.user.mapper.UserMapper;
import com.traveldestination.planner.user.model.response.Destination;
import com.traveldestination.planner.user.model.response.GetApprovedDestinationsResponse;
import com.traveldestination.planner.user.model.response.GetUserUnApprovedDestinationsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class UserService {
    public final FavoriteDestinationsRepositoryFacade favoriteDestinationsRepositoryFacade;
    public final ApprovedDestinationsRepositoryFacade approvedDestinationsRepositoryFacade;
    public final RestCountriesClientFacade restCountriesClientFacade;
    public final UserMapper userMapper;
    public GetApprovedDestinationsResponse getApprovedDestinations(Long userId) {


        return GetApprovedDestinationsResponse.builder()
                .approvedDestinationsEntityList(approvedDestinationsRepositoryFacade.findAll())
                .build();
    }

    public List<GetUserUnApprovedDestinationsResponse> getUnApprovedDestinations(Long userId) {

        //get users favorite destinations
        List<FavoriteDestinationsEntity> getUserFavorites =
                favoriteDestinationsRepositoryFacade.findByUserId(userId);

        //get approved destinations
        GetApprovedDestinationsResponse approvedDestinations = getApprovedDestinations(userId);

        //call client to get all destinations
        List<Destination> allDestinations = getAllDestinations();

//        System.out.println(allDestinations.size());
//        for (Destination destination : allDestinations) {
//            System.out.println(destination.getCountry());
//            System.out.println(destination.getCapital());
//            System.out.println(destination.getRegion());
//            System.out.println(destination.getPopulation());
//            System.out.println(destination.getCurrency());
//            System.out.println(destination.getFlagUrl());
//            System.out.println("-------------------");
//        }
        //build response
        Map<String, Boolean> userFavoritesMap =
                getUserFavoriteDestinationsMap(getUserFavorites);

        Map<String, Boolean> approvedDestinationsMap =
                getApprovedDestinationsMap(approvedDestinations.getApprovedDestinationsEntityList());

        List<GetUserUnApprovedDestinationsResponse> response = new ArrayList<>();
        for (Destination destination : allDestinations) {
            String country = destination.getCountry();
            if (!approvedDestinationsMap.containsKey(country)) {
                boolean isFavorite = userFavoritesMap.getOrDefault(country, false);
                //build unapproved destination response object here
                response.add(GetUserUnApprovedDestinationsResponse
                        .builder()
                                .country(destination.getCountry())
                                .capital(destination.getCapital())
                                .region(destination.getRegion())
                                .population(destination.getPopulation())
                                .currency(destination.getCurrency())
                                .flagUrl(destination.getFlagUrl())
                                .wasFav(isFavorite)
                                .isFav(isFavorite)
                        .build());
            }
        }

        return response;
    }

    public List<Destination> getAllDestinations() {
        return userMapper.map(restCountriesClientFacade.getCountries());
    }

    public Map<String, Boolean> getUserFavoriteDestinationsMap
            (List<FavoriteDestinationsEntity> userFavorites) {

        return userFavorites.stream()
                .collect(
                        java.util.stream.Collectors.toMap(
                                FavoriteDestinationsEntity::getCountry,
                                fav -> true
                        )
                );
    }

    public Map<String, Boolean> getApprovedDestinationsMap(List<ApprovedDestinationsEntity> approvedDestinations) {
        return approvedDestinationsRepositoryFacade.findAll().stream()
                .collect(
                        java.util.stream.Collectors.toMap(
                                ApprovedDestinationsEntity::getCountry,
                                app -> true
                        )
                );
    }
}
