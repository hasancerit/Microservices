package com.example.msscbreweryclient.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.msscbreweryclient.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.msscbreweryclient.web.model.CustomerDto;

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
	
	@Test
	void deleteBeer() {
		breweryClient.delete(UUID.randomUUID());
	}
	
	@Test
    void getCustomerById() {
        CustomerDto dto = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Hasan").build();

        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Hasan").build();

        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomer() {
    	breweryClient.deleteCustomer(UUID.randomUUID());
    }

}
