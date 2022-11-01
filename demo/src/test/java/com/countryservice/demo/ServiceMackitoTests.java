package com.countryservice.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.services.CountryService;
import com.countryservice.repositories.CountryRepository;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {
	
	@Mock
	CountryRepository countryrepo;
	
	@InjectMocks
	CountryService countryService;

	public List<Country> myCountries;
	
	@Test
	@Order(1)
	public void test_getAllCountries()
	{
		myCountries=new ArrayList<Country>();
		myCountries.add(new Country(1,"India", "Delhi"));
		myCountries.add(new Country(2,"USA", "Washington"));

		when(countryrepo.findAll()).thenReturn(myCountries);//Mocking
		assertEquals(2, countryService.getAllCountries().size());
	}
	
	@Test @Order(2)
	public void test_getCountryByID()
	{
		myCountries=new ArrayList<Country>();
		myCountries.add(new Country(1,"India", "Delhi"));
		myCountries.add(new Country(2,"USA", "Washington"));
		
		int countryId=1;
		when(countryrepo.findAll()).thenReturn(myCountries); //Mocking
		assertEquals(1,countryService.getCountryByID(countryId).getId());	
	}
	
	@Test @Order(3)
	public void test_getCountryByName()
	{
		myCountries=new ArrayList<Country>();
		myCountries.add(new Country(1,"India", "Delhi"));
		myCountries.add(new Country(2,"USA", "Washington"));
		
		String countryName="India";
		when(countryrepo.findAll()).thenReturn(myCountries); //Mocking
		assertEquals(countryName,countryService.getCountryByName(countryName).getCountryName());	
	}
	
	@Test @Order(4)
	public void test_addCountry() {
		
	}
}
