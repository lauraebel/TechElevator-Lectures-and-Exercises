package com.techelevator.country;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCountryDAO implements CountryDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	public JDBCCountryDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Country> findCountriesByHeadOfState(String headOfState) {
		List<Country> countries = new ArrayList<>();
		
		String sql = "SELECT code, name FROM country WHERE headofstate = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, headOfState);
		
		while(results.next()) {
			countries.add(mapRowToCountry(results));
		}
		return countries;
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
List<Country> countries = new ArrayList<>();
		
		String sql = "SELECT code, name FROM country WHERE continent LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + continent + "%");
		
		while(results.next()) {
		
			countries.add(mapRowToCountry(results));
		}
		return countries;
	}
	
	private Country mapRowToCountry(SqlRowSet results) {
		Country country = new Country();
		
		country.setName(results.getString("name"));
		country.setCode(results.getString("code"));
		
		return country;
		
	}

}
