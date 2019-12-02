package com.hcl.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.dao.CountryDAO;
import com.hcl.rest.model.Country;

@RestController
public class CountryController {
	
	@Autowired
	CountryDAO countryDAO;
	
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		
		List<Country> listOfCountries = countryDAO.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryDAO.getCountry(id);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Country country) {	
		countryDAO.addCountry(country);
		
	}

	@RequestMapping(value = "/updateCountry", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@RequestBody Country country) {
		countryDAO.updateCountry(country);
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryDAO.deleteCountry(id);		
	}	
}
