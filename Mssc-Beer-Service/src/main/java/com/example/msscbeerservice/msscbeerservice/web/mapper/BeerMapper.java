package com.example.msscbeerservice.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;

import com.example.msscbeerservice.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto BeerToBeerDto(Beer beer);

	Beer BeerDtoToBeer(BeerDto beerDto);
}
