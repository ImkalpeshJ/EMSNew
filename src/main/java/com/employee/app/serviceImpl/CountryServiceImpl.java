package com.employee.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dao.CountryDao;
import com.employee.app.entity.Country;
import com.employee.app.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDao dao;
	
	@Override
	public List<Country> getAllCountry() {
		return dao.getAllCountry();
	}

	@Override
	public boolean postCountry(Country country) {
		return dao.postCountry(country);
	}

	@Override
	public boolean updateCountry(Country country) {
		return dao.updateCountry(country);
	}

	@Override
	public boolean deleteCountry(int id) {
		return dao.deleteCountry(id);
	}

	@Override
	public Country getCountryById(int id) {
		return dao.getCountryById(id);
	}

}
