package com.gethrtables.gethrtables.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import com.gethrtables.gethrtables.models.Country;
import com.gethrtables.gethrtables.repositories.CountryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/country")
public class CountryController {	
	
	@Autowired
	private CountryRepository countryRepository;
    
    @GetMapping
    public List<Country> getAllCountries() throws SQLException {
        return Collections.unmodifiableList(countryRepository.getAllCountry());
    }

    @PostMapping(value = "/create" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createCountry(@RequestBody Country country) {
        System.out.println("In create method");
        return countryRepository.addCountry(country);
    }

    @GetMapping({"/{countryID}"})
    public Country showInfo(@PathVariable String countryID) {
        return countryRepository.getCountryByID(countryID);
    }
}
