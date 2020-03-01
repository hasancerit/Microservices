package com.example.msscbreweryclient.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

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

}
