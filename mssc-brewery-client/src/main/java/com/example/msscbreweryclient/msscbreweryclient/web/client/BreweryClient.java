package com.example.msscbreweryclient.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.msscbreweryclient.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.msscbreweryclient.web.model.CustomerDto;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

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
    
    public void delete(UUID uuid) {
    	restTemplate.delete(apihost + BEER_PATH_V1+"/"+uuid.toString());
    }
    
    public void updateBeer(UUID id, BeerDto beer) {
    	restTemplate.put(apihost + BEER_PATH_V1+"/"+id.toString(), beer);
    }
    
    public void setApihost(String apihost) {
    	System.out.println("Apihost atandı");
        this.apihost = apihost;
    }
    
    
    
    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return  restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
    }
}