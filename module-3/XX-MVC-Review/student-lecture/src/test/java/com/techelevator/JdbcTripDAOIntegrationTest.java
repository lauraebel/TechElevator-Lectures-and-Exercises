package com.techelevator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.JDBCTripDAO;
import com.techelevator.dao.TripDAO;
import com.techelevator.dao.model.Trip;

public class JdbcTripDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate template;
	private TripDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/trip-manager");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		dao = new JDBCTripDAO(dataSource);
		template = new JdbcTemplate(dataSource);
		template.update("TRUNCATE TABLE trips");
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void save_trip() {

		Trip trip = getTrip("testTrip");
		dao.save(trip);
		
		Assert.assertTrue(trip.getId() > 0);
		
		List<Trip> trips = dao.getAllTrips();
		Assert.assertEquals(1, trips.size());
	}
	
	@Test
	public void get_all_trips() {
		dao.save(getTrip("testTrip"));
		dao.save(getTrip("testTrip2"));
		dao.save(getTrip("testTrip3"));
		
		List<Trip> trips = dao.getAllTrips();
		
		Assert.assertEquals(3, trips.size());
	}

	
	private Trip getTrip(String name) {
		Trip trip = new Trip();
		trip.setName(name);
		trip.setDescription("testDescription");
		trip.setStartDate(LocalDate.now());
		trip.setEndDate(LocalDate.now().plusDays(10));
		trip.setMiles(100);
		trip.setType("Car");
		return trip;
	}
}
