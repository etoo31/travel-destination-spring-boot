package com.traveldestination.planner.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@AllArgsConstructor
public class RestCountriesClient {

    private final WebClient webClient;


    public List<RestCountryResponse> getAllCountries() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v3.1/all")
                        .queryParam("fields", "name,capital,population,region,currencies,flags")
                        .build())
                .retrieve()
                .bodyToFlux(RestCountryResponse.class)
                .collectList()
                .block();
    }
}
