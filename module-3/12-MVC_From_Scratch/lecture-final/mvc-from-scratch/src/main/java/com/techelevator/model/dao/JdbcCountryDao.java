package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Country;

@Component
public class JdbcCountryDao implements CountryDao {

	private JdbcTemplate db;
	
	@Autowired
	public JdbcCountryDao(DataSource dataSource) {
		this.db = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		
		SqlRowSet rows = db.queryForRowSet("SELECT code, name FROM country ORDER BY name");
		
		while (rows.next()) {
			countries.add( new Country(rows.getString("code"), rows.getString("name")) );
		}
		
		return countries;
	}

}
