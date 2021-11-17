package com.whosaidmeow.msscbreweryclient.web.client;

import com.whosaidmeow.msscbreweryclient.web.model.BeerDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer/";

    private final String host;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder, ApiHost apiHost) {
        this.restTemplate = restTemplateBuilder.build();
        this.host = apiHost.getHost();
    }

    public BeerDTO getBeerById(UUID id) {
        return restTemplate.getForObject(host + BEER_PATH_V1 + id, BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO) {
        return restTemplate.postForLocation(host + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID id, BeerDTO beerDTO) {
        restTemplate.put(host + BEER_PATH_V1 + id, beerDTO);
    }

    public void deleteBeer(UUID id) {
        restTemplate.delete(host + BEER_PATH_V1 + id);
    }
}
