package com.traveldestination.planner.user.service;

import com.traveldestination.planner.common.respository.facade.FavoriteDestinationsRepositoryFacade;
import com.traveldestination.planner.user.model.response.UserFavoriteDestination;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserService {
    public final FavoriteDestinationsRepositoryFacade favoriteDestinationsRepositoryFacade;
    public UserFavoriteDestination getUserFavoriteDestinations(Long userId) {


        return UserFavoriteDestination.builder()
                .favoriteDestinations(favoriteDestinationsRepositoryFacade.findByUserId(userId))
                .build();
    }
}
