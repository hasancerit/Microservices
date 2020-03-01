package com.example.MsscBrewery.MsscBrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.MsscBrewery.MsscBrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImp implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }
    
    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
    
    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl - would add a real impl to update beer
    }
    
    @Override
    public void deleteById(UUID beerId) {
        System.out.println("Deleting a beer...");
    }
  
}
