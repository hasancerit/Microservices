package com.example.msscbeerservice.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.example.msscbeerservice.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.msscbeerservice.web.model.BeerDto;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto BeerToBeerDto(Beer beer);

	Beer BeerDtoToBeer(BeerDto beerDto);
}
