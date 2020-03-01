package com.example.MsscBrewery.MsscBrewery.service;

import java.util.UUID;

import com.example.MsscBrewery.MsscBrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomer(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);

}
