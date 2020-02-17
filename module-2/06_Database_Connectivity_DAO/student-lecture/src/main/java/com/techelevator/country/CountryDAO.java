package com.techelevator.country;

import java.util.List;

public interface CountryDAO {

	List<Country> findCountriesByHeadOfState(String headOfState);
	List<Country> findCountriesByContinent(String continent);
}
