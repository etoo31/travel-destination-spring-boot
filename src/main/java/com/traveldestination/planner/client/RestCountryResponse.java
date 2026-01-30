package com.traveldestination.planner.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountryResponse {

    private Name name;
    private List<String> capital;
    private String region;
    private Long population;
    private Map<String, Currency> currencies;
    private Flags flags;

    @Data
    public static class Name {
        private String common;
        private String official;
    }

    @Data
    public static class Currency {
        private String name;
        private String symbol;
    }

    @Data
    public static class Flags {
        private String png;
        private String svg;
        private String alt;
    }
}