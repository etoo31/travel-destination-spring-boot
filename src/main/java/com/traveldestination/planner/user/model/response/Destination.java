package com.traveldestination.planner.user.model.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Destination {

    private String country;

    private String capital;

    private String region;

    private Long population;

    private String currency;

    private String flagUrl;

}
