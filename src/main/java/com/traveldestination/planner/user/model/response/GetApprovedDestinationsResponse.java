package com.traveldestination.planner.user.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.traveldestination.planner.common.model.entity.ApprovedDestinationsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetApprovedDestinationsResponse {
    @JsonProperty("destinations")
    List<ApprovedDestinationsEntity> approvedDestinationsEntityList;
}
