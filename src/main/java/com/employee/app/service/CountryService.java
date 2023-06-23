package com.employee.app.service;

import java.util.List;

import com.employee.app.entity.Country;

public interface CountryService {

	List<Country> getAllCountry();

	boolean postCountry(Country country);

	boolean updateCountry(Country country);

	boolean deleteCountry(int id);

	Country getCountryById(int id);
}
