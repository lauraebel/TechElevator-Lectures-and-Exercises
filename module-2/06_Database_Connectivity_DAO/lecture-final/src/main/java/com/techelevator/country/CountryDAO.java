package com.techelevator.country;

import java.util.List;

public interface CountryDAO {

	List<Country> findCountriesByContinent(String continent);
	List<Country> findCountriesByHeadOfState(String headOfState);

}
