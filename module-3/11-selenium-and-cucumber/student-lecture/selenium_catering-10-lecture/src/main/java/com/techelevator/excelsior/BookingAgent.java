package com.techelevator.excelsior;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.excelsior.model.Reservation;
import com.techelevator.excelsior.model.Space;
import com.techelevator.excelsior.model.Venue;
import com.techelevator.excelsior.model.dao.jdbc.JDBCCategoryDAO;
import com.techelevator.excelsior.model.dao.jdbc.JDBCReservationDAO;
import com.techelevator.excelsior.model.dao.jdbc.JDBCSpaceDAO;
import com.techelevator.excelsior.model.dao.jdbc.JDBCVenueDAO;

@Component
public class BookingAgent {

	@Autowired
	JDBCVenueDAO jdbcVenueDAO;
	
	@Autowired
	JDBCSpaceDAO jdbcSpaceDAO;
	
	@Autowired
	JDBCReservationDAO jdbcReservationDAO;
	
	@Autowired
	JDBCCategoryDAO jdbcCategoryDAO;

	List<Venue> venues = null;

	public BookingAgent() {
		
	}
	
	public BookingAgent(DataSource datasource) {
		jdbcVenueDAO = new JDBCVenueDAO(datasource);
		jdbcSpaceDAO = new JDBCSpaceDAO(datasource);
		jdbcReservationDAO = new JDBCReservationDAO(datasource);
		jdbcCategoryDAO = new JDBCCategoryDAO(datasource);
	}

	public List<Venue> getVenues() {
		if (venues == null) {
			venues = jdbcVenueDAO.getVenues(jdbcSpaceDAO, jdbcCategoryDAO);
		}
		return venues;
	}

	public List<String> getCategories() {
		return jdbcCategoryDAO.getAllCategories();
	}

	public List<Space> getAllAvailableSpaces(LocalDate startDate, LocalDate endDate, int numberOfAttendees,
			boolean isAccessible, double dailyRate, int category) {
		return jdbcSpaceDAO.getAllAvailableSpaces(startDate, endDate, numberOfAttendees, isAccessible, dailyRate,
				category);
	}

	public List<Space> getAvailableSpacesForVenue(long venueId, LocalDate startDate, LocalDate endDate,
			int numberOfAttendees) {
		return jdbcSpaceDAO.getAvailableSpacesForVenue(venueId, startDate, endDate, numberOfAttendees);
	}

	public Reservation addReservation(long spaceId, int numberOfAttendees, LocalDate startDate, LocalDate endDate,
			String reservedFor) {
		return jdbcReservationDAO.addReservation(spaceId, numberOfAttendees, startDate, endDate, reservedFor);
	}

	public List<Reservation> getThirtyDayReservations(long venueId) {
		return jdbcReservationDAO.getUpcomingReservations(venueId);
	}

}
