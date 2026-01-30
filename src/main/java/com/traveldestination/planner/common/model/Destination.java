package com.traveldestination.planner.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

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
}
