package com.example.msscbeerservice.msscbeerservice.services.imp;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msscbeerservice.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.msscbeerservice.repositories.BeerRepository;
import com.example.msscbeerservice.msscbeerservice.services.BeerService;
import com.example.msscbeerservice.msscbeerservice.web.mapper.BeerMapper;
import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
public class BeerServiceImp implements BeerService{
	@Autowired
	private BeerRepository beerRepository;
	@Autowired
	private BeerMapper beerMapper;
	
	@Override
	public BeerDto getById(UUID id) {
		// TODO Auto-generated method stub
		return beerMapper.BeerToBeerDto(beerRepository.findById(id).get());
	}

	@Override
	public BeerDto saveNewBeer(@Valid BeerDto beerDto) {
		// TODO Auto-generated method stub
		return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeerById(UUID id, @Valid BeerDto beerDto) {
		// TODO Auto-generated method stub
		Beer beer = beerRepository.findById(id).get();

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStye().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.BeerToBeerDto(beerRepository.save(beer));	}

}
