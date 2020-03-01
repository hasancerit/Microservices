package com.example.MsscBrewery.MsscBrewery.service;

import java.util.UUID;

import com.example.MsscBrewery.MsscBrewery.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteById(UUID beerId);



}
