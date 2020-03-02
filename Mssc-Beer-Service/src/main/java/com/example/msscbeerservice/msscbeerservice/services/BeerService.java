package com.example.msscbeerservice.msscbeerservice.services;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;

public interface BeerService {

	BeerDto getById(UUID id);

	BeerDto saveNewBeer(@Valid BeerDto beerDto);

	BeerDto updateBeerById(UUID id, @Valid BeerDto beerDto);

}
