package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

// Notice that the JDBCCityDao is implementing the CityDAO interface. When we write our application code, we should refer
// to the interface instead of the JDBCCityDAO directly. This creates a flexible design that will allow us to implement a
// new CityDAO more easily, and also allows us to unit test the code that uses the interface.
public class JDBCCityDAO implements CityDAO {

	// We are making the JdbcTemplate object private and final so it can only be set
	// here or in the constructor. This prevents
	// us (or other developers) from changing the variable anywhere else in the
	// code, which could lead to unexpected results otherwise.
	private final JdbcTemplate jdbcTemplate;

	// Our JDBCCityDAO has a "dependency" on the DataSource. Because we have
	// explicitly defined a constructor, we cannot create an instance of the
	// JDBCCityDAO without passing in the DataSource. Our DataSource dependency is
	// being "injected" into the constructor.
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		// This is the SQL query we want to run on the database to INSERT the new city.
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) "
				+ "VALUES(?, ?, ?, ?, ?)";

		// Because our INSERT statement requires us to provide an ID for the new city,
		// we need to get the next id from the sequence before we can insert the data.

		// It is also worth noting that the ID on the city will now also be updated in
		// the place where we called this code from. This is because we passed a
		// reference to the object when we called the method. As such, any changes to
		// the object are made to the value in memory.
		newCity.setId(getNextCityId());

		// Now we can actually run our INSERT statement against the database. Each of
		// the '?' in the SQL query are replaced with the data from the city that was
		// passed to this method. The question marks are important because it protects
		// us from SQL injection vulnerabilities through the use of parameterized
		// queries.
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(),
				newCity.getDistrict(), newCity.getPopulation());
	}

	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population FROM city WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);

		// In this case, we only expect to get a single result back from our query. We
		// need to call the next() method on the SqlRowSet to advance to the first row
		// of results. If there are not any rows left to look at, next() will return
		// false. For instance, if we tried to get a city where the id didn't match an
		// existing city, we would not get any data back, which means there isn't a
		// next() row. However, if it does find a match, next() will return true.
		if (results.next()) {
			// We found a matching city, so now we need to turn the SqlRowSet into an actual
			// City object. We do this by calling the mapRowToCity method, passing the
			// SqlRowSet as a parameter
			theCity = mapRowToCity(results);
		}

		// if we found a city, then the value of the theCity object is the city that was
		// created in the mapRowToCity method. Otherwise, it will be null (because that
		// is what it was initialized as).
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		// Sometimes, we also need to get multiple rows back from the database.
		// In this case, we are getting all of the cities for a specified countryCode.

		// First we need to create a new List<City> to hold the cities we want to
		// return.
		List<City> cities = new ArrayList<>();

		// Write the SQL query to get the cities that have the matching country code.
		// Again, notice that we are using the question mark. Why is this important?
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population"
				+ " FROM city WHERE countrycode = ?";

		// Send the query to the database and store the results in a SqlRowSet object
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);

		// Instead of simply checking "if" we got a row back, this time we could get
		// multiple rows. Because of this, we need to loop through the rows while there
		// are still rows left to "look at".
		while (results.next()) {
			// Create a new City object by passing the SqlRowSet we are currently on to the
			// mapRowToCity method.
			City theCity = mapRowToCity(results);

			// Now, add the city we just created to the List of City objects.
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the next id from the sequence for the city table.
	 *
	 * @return The next id in the city id sequence.
	 */
	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");

		// Remember, we only get a single row back, so we just need to check if we got a
		// row.
		if (nextIdResult.next()) {
			// While we usually get the columns by name explicitly (see the mapCityToRow
			// method), we can also get a column at a specific index. Keep in mind the index
			// starts at one (1), unlike arrays that start at an index of zero (0).
			return nextIdResult.getLong(1);
		} else {
			// in this case, if we weren't able to get a single row back, we need to throw
			// an unchecked RuntimeException.
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	/**
	 * When we get data back from the database, we typically get back a SqlRowSet.
	 * This is where the data from the query is stored. However, we usually need to
	 * translate that data into objects. As such, we will usually create a "mapper"
	 * method that will accept a single row from our results, and return a new
	 * object with the data added to it from the database.
	 *
	 * @param results Represents a row of data from a query. This includes the
	 *                columns we want to use when we create a new city.
	 * @return Returns a new City object populated with the data from the SqlRowSet
	 */
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		// We need to get the data out of each column for the row and add it to the new
		// City object we've created

		// We get the data from the column using the name of the column. We also need to
		// specify the datatype we want to get back.

		// For instance, in this case, we want the ID column to be represented as a long
		theCity.setId(results.getLong("id"));

		// However in this case, we want to get the name column as a String
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));

		// Once we're done setting the values of our new object, we return the object.
		// The object is now "hydrated".
		// (https://stackoverflow.com/questions/6991135/what-does-it-mean-to-hydrate-an-object)
		return theCity;
	}
}
