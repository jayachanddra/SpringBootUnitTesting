package com.countryservice.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	//static HashMap<Integer, Country> countryIdMap;
	@Autowired
	AddResponse addresponse;
	
	@Autowired
	CountryRepository countryrepo;
	/*public CountryService() {
		countryIdMap=new HashMap<Integer, Country>();
		
		Country indiaCountry=new Country(1, "India", "Delhi");
		Country usaCountry=new Country(2, "USA", "Washington");
		Country ukCountry=new Country(3, "UK", "London");
		
		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);
		
	}*/
	
	public List<Country> getAllCountries()
	{
		return countryrepo.findAll();
	}
	
	public Country getCountryByID(int id) {
		return countryrepo.findById(id).get();
	}
	
	public Country getCountryByName(String countryName) {
		
		List<Country> countrieslist=countryrepo.findAll(); 
		Country country = null;
		for(Country con:countrieslist) {
			if(con.getCountryName().equalsIgnoreCase(countryName)) {
				country=con;
			}
		}
		return country;
	}
	
	public Country addCountry(Country country) {
		/*
		 * country.setId(getMaxId()); countryIdMap.put(country.getId(), country); return
		 * country;
		 */
		country.setId(getMaxId());
		countryrepo.save(country);
		return country;
	}
	
	public Country updateCountry(Country country) {
		/*
		 * if(country.getId()>0) countryIdMap.put(country.getId(), country); return
		 * country;
		 */

		countryrepo.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		/*
		 * countryIdMap.remove(id); addresponse.setMsg("Country deleted");
		 * addresponse.setId(id); return addresponse;
		 */
		countryrepo.deleteById(id);
		addresponse.setMsg("Country deleted");
		addresponse.setId(id); 
		return addresponse;
		
		
	}

	private int getMaxId() {
		/*
		 * int max=0; for (int id:countryIdMap.keySet()) if(max<=id) max=id; return
		 * max+1;
		 */
		return countryrepo.findAll().size()+1;
	}
	

}
