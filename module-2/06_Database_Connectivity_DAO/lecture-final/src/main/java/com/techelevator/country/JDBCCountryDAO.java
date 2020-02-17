package com.techelevator.country;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCountryDAO implements CountryDAO {

	private final JdbcTemplate jdbcTemplate;

	public JDBCCountryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
		List<Country> countries = new ArrayList<>();

		String sql = "SELECT code, name FROM country WHERE continent LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + continent + "%");

		while (results.next()) {
			countries.add(mapRowToCountry(results));
		}

		return countries;
	}

	@Override
	public List<Country> findCountriesByHeadOfState(String headOfState) {
		List<Country> countries = new ArrayList<>();

		String sql = "SELECT code, name FROM country WHERE headofstate = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, headOfState);

		while (results.next()) {
			countries.add(mapRowToCountry(results));
		}

		return countries;
	}

	private Country mapRowToCountry(SqlRowSet result) {
		Country country = new Country();

		country.setName(result.getString("name"));
		country.setCode(result.getString("code"));

		return country;
	}

}
