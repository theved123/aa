package com.vedjunit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.vedjunit.Exception.RecordNotFound;
import com.vedjunit.entity.Country;
import com.vedjunit.repository.CountryRepo;

@Service
public class CountryServiceImpl implements CountryServiceI {

	@Autowired
	private CountryRepo countryRepo;

// save country
	@Override
	public Country saveCountry(Country con) {
		Country save = this.countryRepo.save(con);

		return save;
	}
//save  AllCountry

	public List<Country> saveAllCountry(List<Country> list) {

		List<Country> saveAll = this.countryRepo.saveAll(list);
		return saveAll;
	}

// get All Countries
	public List<Country> getAllCountries() {
		List<Country> list = this.countryRepo.findAll();

		return list;
	}

// get Single Country

	public Country getCountryById(Integer id) {

		List<Country> findAll = this.countryRepo.findAll();

		Country country = null;
		for (Country con : findAll) {

			if (con.getId() == id) {

				country = con;

			} else {

				throw new RecordNotFound(101, "No Record Found");
			}

		}
		return country;

	}

// update country
	@Override
	public Country updateCountry(Country con, Integer id) {
		con.setId(id);
		Country update = this.countryRepo.save(con);

		return update;
	}

	// delete country	
	public void deleteCountry(Country con) {
		countryRepo.delete(con);

	}



}
