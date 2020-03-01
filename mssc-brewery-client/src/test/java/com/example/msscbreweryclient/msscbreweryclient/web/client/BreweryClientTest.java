package com.example.msscbreweryclient.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.msscbreweryclient.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	@Autowired
	BreweryClient breweryClient;
	
	@Test
	void GetBeerById() {
		BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void saveNewBeer() {
		BeerDto dto = BeerDto.builder().build();
		
		URI uri = breweryClient.saveNewBeer(dto);
		
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void updateBeer() {
		BeerDto dto = BeerDto.builder().build();
		breweryClient.updateBeer(UUID.randomUUID(), dto);
	}

}
