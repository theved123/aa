package com.vedjunit.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.vedjunit.Exception.RecordNotFound;
import com.vedjunit.entity.Country;
import com.vedjunit.repository.CountryRepo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { CountryServiceImplTest.class })
class CountryServiceImplTest {

//	Junit class dependent on this(basically it create dummy Object)
	@Mock
	private CountryRepo countryRepo;

// we are writing Junit of this
	@InjectMocks
	private CountryServiceI countryService;

// 1. Get All Countries
	@Test
	public void testgetAllCountries() {

		List<Country> mylist = new ArrayList<Country>();
		mylist.add(new Country(1, "India", "MH"));
		mylist.add(new Country(2, "Sri-Kanka", "Dhaka"));

		when(countryRepo.findAll()).thenReturn(mylist);

		int actual = countryService.getAllCountries().size();

		assertEquals(2, actual);

	}

// 1. Get Country by Id
	@Test
	public void testgetCountryById() {

		List<Country> mylist = new ArrayList<Country>();
		mylist.add(new Country(1, "India", "MH"));
		mylist.add(new Country(2, "Sri-Kanka", "Dhaka"));
		int countryid = 1;
		Integer actual = countryService.getCountryById(countryid).getId();
		assertEquals(countryid, actual);
	}

// add country
	@Test
	public void testsaveCountry() {
		Country c = new Country(1, "India", "MH");

		when(countryRepo.save(c)).thenReturn(c);
		Country actual = countryService.saveCountry(c);
		assertEquals(c, actual);
	}

// update country

	@Test
	public void testupdateCountry() {
		Country c = new Country(1, "India", "MH");
		int cid = 1;
		when(countryRepo.save(c)).thenReturn(c);
		Country actual = countryService.updateCountry(c, cid);
		assertEquals(c, actual);
	}

// delete country

	@Test
	public void testdeleteCountry() {
		Country c = new Country(1, "India", "MH");
		countryService.deleteCountry(c);
		verify(countryRepo, times(1)).delete(c);
	}

// Exception Check
	@Test
	public void testgetCountryByIdException() {
		Country c = new Country(1, "India", "MH");
		int cid = 1;
		assertThrows(RecordNotFound.class, () -> c.getId());

	}

}
