package com.traveldestination.planner.user.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GetUserUnApprovedDestinationsResponse {

    @JsonProperty("country")
    private String country;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("region")
    private String region;

    @JsonProperty("population")
    private Long population;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("flagUrl")
    private String flagUrl;

    @JsonProperty("wasFav")
    private boolean wasFav;

    @JsonProperty("isFav")
    private boolean isFav;


}
