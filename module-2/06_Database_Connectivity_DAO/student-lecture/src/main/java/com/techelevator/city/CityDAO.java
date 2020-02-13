package com.techelevator.city;

import java.util.List;

/**
 * This interface is an example of a Data Access Object (DAO). A DAO defines the
 * contract for creating, updating, deleting, and getting data from a database,
 * file, API, or other storage media. This is what allows us to generically
 * refer to the way we want to interact with our data (in this case a database)
 * with Java.
 **/
public interface CityDAO {

	public void save(City newCity);

	public City findCityById(long id);

	public List<City> findCityByCountryCode(String countryCode);

	public List<City> findCityByDistrict(String district);

	public void update(City city);

	public void delete(long id);
}
