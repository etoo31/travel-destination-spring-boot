package com.traveldestination.planner.user.service;

import com.traveldestination.planner.common.respository.facade.ApprovedDestinationsRepositoryFacade;
import com.traveldestination.planner.common.respository.facade.FavoriteDestinationsRepositoryFacade;
import com.traveldestination.planner.user.model.response.GetApprovedDestinationsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserService {
    public final FavoriteDestinationsRepositoryFacade favoriteDestinationsRepositoryFacade;
    public final ApprovedDestinationsRepositoryFacade approvedDestinationsRepositoryFacade;
    public GetApprovedDestinationsResponse getApprovedDestinations(Long userId) {


        return GetApprovedDestinationsResponse.builder()
                .approvedDestinationsEntityList(approvedDestinationsRepositoryFacade.findAll())
                .build();
    }
}
