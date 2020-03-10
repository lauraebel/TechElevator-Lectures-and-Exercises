package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.City;

@Component
public class JdbcCityDao implements CityDao {

	private JdbcTemplate db;
	
	@Autowired
	public JdbcCityDao(DataSource dataSource) {
		this.db = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<City> getAllCitiesByCountryCode(String code) {
		List<City> cities = new ArrayList<City>();
		SqlRowSet rows = db.queryForRowSet("SELECT name FROM city WHERE countryCode = ? ORDER BY name", code);
		
		while (rows.next()) {
			cities.add(new City(rows.getString("name")));
		}
		
		return cities;
	}

}
