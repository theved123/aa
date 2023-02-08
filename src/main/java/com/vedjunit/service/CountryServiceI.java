package com.vedjunit.service;

import java.util.List;

import com.vedjunit.entity.Country;

public interface CountryServiceI {

	public Country saveCountry(Country con);
	public List<Country> saveAllCountry(List<Country> list);
	public Country getCountryById(Integer id);
	public List<Country>  getAllCountries();
	public Country updateCountry(Country con,Integer id);
	public void deleteCountry(Country con);

	
}
