package com.example.msscbeerservice.msscbeerservice.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	@GetMapping("/{id}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID id){
		return new ResponseEntity<BeerDto>(BeerDto.builder().beerName("name").build(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v1/beer/" + UUID.randomUUID().toString());

        return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BeerDto> updateBeerById(@PathVariable UUID id,@Valid @RequestBody BeerDto beerDto){	
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
}
