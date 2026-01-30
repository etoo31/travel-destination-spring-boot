package com.traveldestination.planner.user.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserUnApprovedDestinations {

    @JsonProperty("destinations")
    export class UnApprovedDestinations {
        flagUrl: string = '';
        country: string = '';
        capital: string = '';
        region: string = '';
        population: number = 0;
        currency: string = '';
        wasFav: boolean = false;
        isFav: boolean = false;
    }

}
