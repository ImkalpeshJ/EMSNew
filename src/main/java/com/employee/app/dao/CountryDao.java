package com.employee.app.dao;

import java.util.List;

import com.employee.app.entity.Country;

public interface CountryDao {

	List<Country> getAllCountry();

	boolean postCountry(Country country);

	boolean updateCountry(Country country);

	boolean deleteCountry(int id);

	Country getCountryById(int id);
}
