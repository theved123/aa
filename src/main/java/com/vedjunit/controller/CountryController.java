package com.vedjunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vedjunit.entity.Country;
import com.vedjunit.service.CountryServiceImpl;

@RestController
public class CountryController {

	@Autowired
	private CountryServiceImpl CountryServiceI;

	// save country
	@PostMapping("/saveCountry")
	public ResponseEntity<Country> saveCountry(@RequestBody Country con) {

		Country saveCountry = CountryServiceI.saveCountry(con);
		return new ResponseEntity<Country>(saveCountry, HttpStatus.CREATED);

	}

	// save All
	@PostMapping("/saveAllCountry")
	public ResponseEntity<List<Country>> saveAllEmployee(@RequestBody List<Country> list) {
		List<Country> saveAllCountry = CountryServiceI.saveAllCountry(list);

		return new ResponseEntity<List<Country>>(saveAllCountry, HttpStatus.CREATED);

	}

	// get all
	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> allCountries = CountryServiceI.getAllCountries();
		return new ResponseEntity<List<Country>>(allCountries, HttpStatus.OK);

	}

	// get single
	@GetMapping("/getCountrybyid/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable int id) {
		Country byId = CountryServiceI.getCountryById(id);
		return new ResponseEntity<Country>(byId, HttpStatus.FOUND);

	}

	// update Country
	@PostMapping("/updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country con) {

		Country saveCountry = CountryServiceI.saveCountry(con);
		return new ResponseEntity<Country>(saveCountry, HttpStatus.OK);

	}
// delete user

	@DeleteMapping("/deleteCountry")
	public void deleteCountry(Country con) {

		CountryServiceI.deleteCountry(con);

	}

}
