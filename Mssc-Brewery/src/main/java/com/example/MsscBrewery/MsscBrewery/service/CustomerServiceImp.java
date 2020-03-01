package com.example.MsscBrewery.MsscBrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.MsscBrewery.MsscBrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImp implements CustomerService{
	   @Override
	    public CustomerDto getCustomerById(UUID customerId) {
	        return CustomerDto.builder()
	                .id(UUID.randomUUID())
	                .name("Joe Buck")
	                .build();
	    }
	   
	   @Override
	    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
	        return CustomerDto.builder()
	                .id(UUID.randomUUID())
	                .build();
	    }

	    @Override
	    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
	        System.out.println("Updating....");
	    }

	    @Override
	    public void deleteById(UUID customerId) {
	        System.out.println("Deleting.... ");
	    }
}
