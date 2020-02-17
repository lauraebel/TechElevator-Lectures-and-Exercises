package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/*
 * Spring JDBC is a wrapper around Java JDBC that makes connecting to a database and
 * executing queries easier and more concise.
 */
public class SpringJDBCExample {

	public static void main(String[] args) {

		/*
		 * This datasource will be used for creating connections to the database. Below,
		 * we provide the information required to make database connections
		 */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore"); //Connection String
								//^protocol        //^host    //^port//^database to connect to
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");
		//^Credentials
		
		/*
		 * The JdbcTemplate is the main interface we use to interact with databases
		 * using Spring JDBC.
		 */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);

		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory = "SELECT film.title, film.release_year "
			+ "FROM film JOIN film_category ON film.film_id = film_category.film_id "
			+ "JOIN category ON category.category_id = film_category.category_id " + "WHERE category.name = ?";
		//^SQL query all in the String datatype
		
		/*
		 * The first parameter to the "queryForRowSet" method is a String containing a
		 * parameterized SQL statement Any following parameters are used to replace
		 * query placeholders (i.e. '?') in the order in which they appear
		 */
		String category = "Comedy";
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);
	//^Sending the query to the database and replaces the ? (parameterized) with the variable called category
		System.out.println(category + " Films:");

		/*
		 * The "next" method advances the cursor to the next row if a row exists
		 */
		while (results.next()) {
			// this is the title column from the SELECT statement above
			String filmTitle = results.getString("title");
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle + " (" + releaseYear + ")");
		}

		// use the "update" method to run INSERT, UPDATE, and DELETE statements
		
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) " + "VALUES (?, ?, ?)";
		//^will add a row to our actor table
		
		dvdstoreJdbcTemplate.update(sqlCreateActor, 1000, "Craig", "Castelaz");

		/*
		 * The next example makes use of the world database, so we need a new DataSource
		 * for creating connections to that database.
		 */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");

		/*
		 * The JdbcTemplate is the main interface we use to interact with databases
		 * using Spring JDBC.
		 */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);

		/*
		 * Sequences are often used to generate a unique Id value prior to inserting a
		 * new record. (***like a serial primary key)
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);
		
		// advances to the first row
		results.next();
		
		// returns the integer value of the first column (i.e. index 1)
		//* DOES NOT START AT 0 IN SQLROWSET LIKE OTHER THINGS IN JAVA!
		int id = results.getInt(1);
		System.out.println("New city id: " + id);

		/*
		 * Now create a new city record using the generated id
		 */
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "
				+ "VALUES(?, ?, ?, ?, ?)";

		worldJdbcTemplate.update(sqlCreateNewCity, id, "Smallville", "USA", "Kansas", 45001);
	}
}
