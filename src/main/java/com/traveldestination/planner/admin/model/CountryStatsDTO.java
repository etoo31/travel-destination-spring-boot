package com.traveldestination.planner.admin.model;

import lombok.Getter;

public record CountryStatsDTO(
        String country,
        String capital,
        String region,
        Long population,
        String currency,
        String flag,
        Long noOfSuggestions
) {}