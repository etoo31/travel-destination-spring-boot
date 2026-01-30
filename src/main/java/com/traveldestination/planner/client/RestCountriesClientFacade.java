package com.traveldestination.planner.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestCountriesClientFacade {

    private final RestCountriesClient client;

    public List<RestCountryResponse> getCountries() {
        try {
            return client.getAllCountries();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch countries from RestCountries API", e);
        }
    }

}
