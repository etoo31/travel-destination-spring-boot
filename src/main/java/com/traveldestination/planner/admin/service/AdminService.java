package com.traveldestination.planner.admin.service;

import com.traveldestination.planner.admin.mapper.AdminMapper;
import com.traveldestination.planner.common.model.Destination;
import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import com.traveldestination.planner.common.respository.facade.ApprovedDestinationsRepositoryFacade;
import com.traveldestination.planner.common.respository.facade.FavoriteDestinationsRepositoryFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final FavoriteDestinationsRepositoryFacade favoriteDestinationsRepositoryFacade;
    private final ApprovedDestinationsRepositoryFacade approvedDestinationsRepositoryFacade;
    private final AdminMapper adminMapper;
    public void approveDestination(long userId, Destination destination) {
        // Remove from favorite destinations if exists
        favoriteDestinationsRepositoryFacade.deleteByCountry(destination.getCountry());

        // Add to approved destinations
        ApprovedDestinationsEntity approvedDestinationsEntity = adminMapper.map(destination);

        approvedDestinationsRepositoryFacade.save(approvedDestinationsEntity);

    }
}
