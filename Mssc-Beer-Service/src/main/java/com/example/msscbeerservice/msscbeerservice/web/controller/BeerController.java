package com.example.msscbeerservice.msscbeerservice.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.msscbeerservice.msscbeerservice.services.BeerService;
import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final BeerService beerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID id){
		return new ResponseEntity<BeerDto>(beerService.getById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        return  new ResponseEntity<BeerDto>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BeerDto> updateBeerById(@PathVariable UUID id,@Valid @RequestBody BeerDto beerDto){	
		return new ResponseEntity<BeerDto>(beerService.updateBeerById(id,beerDto),HttpStatus.NO_CONTENT);
	}
}
