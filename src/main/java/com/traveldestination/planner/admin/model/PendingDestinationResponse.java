package com.traveldestination.planner.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.traveldestination.planner.common.model.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PendingDestinationResponse {
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

    @JsonProperty("noOfSuggestions")
    Long noOfSuggestions;

}
