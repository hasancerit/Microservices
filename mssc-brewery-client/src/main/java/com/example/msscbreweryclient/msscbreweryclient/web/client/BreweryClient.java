package com.example.msscbreweryclient.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.msscbreweryclient.msscbreweryclient.web.model.BeerDto;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;
    
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }
    
    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void setApihost(String apihost) {
    	System.out.println("Apihost atandı");
        this.apihost = apihost;
    }
}