package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;
import com.techelevator.country.Country;
import com.techelevator.country.CountryDAO;
import com.techelevator.country.JDBCCountryDAO;

public class DAOExample {

	public static void main(String[] args) {

		// The first thing we need to do is create a data source, because the
		// JDBCCityDao has a "dependency" on a DataSource object.
		// The BasicDataSource provides a pool of connections that will use the
		// connection string and credentials (username and password) to connect to the
		// database.
		BasicDataSource worldDataSource = new BasicDataSource();

		// The URL we are using is in a special format that tells our DataSource what
		// kind of database driver we want to use.
		// It consists of the protocol (jdbc:postgresql), the host (localhost:5432), and
		// the database (world)
		// (https://docs.oracle.com/cd/E17952_01/connector-j-8.0-en/connector-j-reference-jdbc-url-format.html)
		// Typically, it is not best practice to store connection strings in our code.
		// Instead, we would add our connection strings to configuration files that are
		// not in source control and that are secure. However, for now, this will be
		// fine.
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");

		// We pass or "inject" the dependency into the constructor of the JDBCCityDAO.
		// Also note that when we declare the dao variable, we give it the type CityDAO.
		// Why is this important? What object-oriented programming principle might this
		// be an example of?
		CityDAO dao = new JDBCCityDAO(worldDataSource);

		// We need to create a new city object because our dao has a method to save a
		// City to the database. This means we need to pass a City object to the method.
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		// We are calling the save method on the CityDAO object. What type of object is
		// the dao variable?
		dao.save(smallville);

		// When we saved the city above, we didn't add an ID explicitly to the object.
		// However, we are trying to find the city by the ID. You might be thinking that
		// this wouldn't return anything, or that it would return the city from the
		// database with an id of 0 (because that is the default value for an int data
		// type.) However, because the save method is setting the id on the object we
		// pass in, the id is updated in this class as well.
		City theCity = dao.findCityById(smallville.getId());

		CountryDAO countryDao = new JDBCCountryDAO(worldDataSource);

		List<Country> countries = countryDao.findCountriesByHeadOfState("Elisabeth II");

		for (Country country : countries) {
			System.out.println(country.getName() + " (" + country.getCode() + ")");
		}

		countries = countryDao.findCountriesByContinent("America");
		for (Country country : countries) {
			System.out.println(country.getName() + " (" + country.getCode() + ")");
		}
	}
}
