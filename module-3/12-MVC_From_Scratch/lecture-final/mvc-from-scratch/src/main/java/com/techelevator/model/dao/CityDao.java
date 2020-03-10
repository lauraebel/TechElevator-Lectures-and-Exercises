package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.City;

public interface CityDao {

	List<City> getAllCitiesByCountryCode(String code);
}
