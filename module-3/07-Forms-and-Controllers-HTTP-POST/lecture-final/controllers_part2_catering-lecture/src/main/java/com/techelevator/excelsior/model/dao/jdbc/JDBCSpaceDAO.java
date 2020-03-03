package com.techelevator.excelsior.model.dao.jdbc;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.excelsior.model.Space;
import com.techelevator.excelsior.model.dao.SpaceDAO;

public class JDBCSpaceDAO implements SpaceDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCSpaceDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Space> getAllAvailableSpaces(LocalDate startDate, LocalDate endDate, int numberOfAttendees,
			boolean isAccessible, double dailyRate, int category) {
		List<Space> space = new LinkedList<Space>();
		int startMonth = startDate.getMonthValue();
		int endMonth = endDate.getMonthValue();
		String dailyRateString = String.valueOf(dailyRate);

		String sql = "SELECT DISTINCT space.id AS id, space.venue_id AS venue_id, space.name AS name, "
				+ "is_accessible, open_from, open_to, daily_rate::decimal, max_occupancy, "
				+ "venue.name AS venue_name FROM space JOIN venue ON space.venue_id = "
				+ "venue.id FULL JOIN category_venue ON venue.id = category_venue.venue_id WHERE "
				+ "(is_accessible = true OR is_accessible = ?) AND daily_rate <= ?::money AND ";
		if (category != 0) {
			sql = sql + "category_id = ? AND ";
		}

		sql = sql + "(((? BETWEEN open_from AND open_to) AND (? BETWEEN open_from "
				+ "AND open_to) ) OR open_from IS NULL) AND space.id NOT IN ( SELECT DISTINCT "
				+ "space_id FROM reservation WHERE ( ? BETWEEN start_date AND end_date ) OR (? "
				+ "BETWEEN start_date AND end_date)) AND ? <= max_occupancy ORDER BY venue_name";

		SqlRowSet spaceResults;

		if (category != 0) {
			spaceResults = jdbcTemplate.queryForRowSet(sql, isAccessible, dailyRateString, category, startMonth,
					endMonth, startDate, endDate, numberOfAttendees);
		} else {
			spaceResults = jdbcTemplate.queryForRowSet(sql, isAccessible, dailyRateString, startMonth, endMonth,
					startDate, endDate, numberOfAttendees);
		}

		while (spaceResults.next()) {
			space.add(mapRowToSpace(spaceResults));
		}

		return space;
	}

	@Override
	public List<Space> getSpacesByVenueId(long venueId) {
		List<Space> space = new LinkedList<Space>();

		String sql = "SELECT space.id AS id, venue_id, space.name AS name, is_accessible, "
				+ "open_from, open_to, daily_rate::decimal, max_occupancy, venue.name AS venue_name "
				+ "FROM space JOIN venue ON venue_id = venue.id WHERE venue_id = ?";
		SqlRowSet spaceResults = jdbcTemplate.queryForRowSet(sql, venueId);

		while (spaceResults.next()) {
			space.add(mapRowToSpace(spaceResults));
		}

		return space;
	}

	@Override
	public List<Space> getAvailableSpacesForVenue(long venueId, LocalDate startDate, LocalDate endDate,
			int numberOfAttendees) {
		List<Space> space = new LinkedList<Space>();
		int startMonth = startDate.getMonthValue();
		int endMonth = endDate.getMonthValue();

		String sql = "SELECT space.id AS id, venue_id, space.name AS name, is_accessible, open_from, "
				+ "open_to, daily_rate::decimal, max_occupancy, venue.name AS venue_name FROM space "
				+ "JOIN venue ON space.venue_id = venue.id WHERE venue_id = ? AND (((? BETWEEN open_from "
				+ "AND open_to) AND (? BETWEEN open_from AND open_to) ) OR open_from IS NULL) "
				+ "AND space.id NOT IN ( SELECT DISTINCT space_id FROM reservation "
				+ "WHERE ( ? BETWEEN start_date AND end_date ) OR (? BETWEEN start_date AND end_date))  "
				+ "AND ? <= max_occupancy LIMIT 5";

		SqlRowSet spaceResults = jdbcTemplate.queryForRowSet(sql, venueId, startMonth, endMonth, startDate, endDate,
				numberOfAttendees);

		while (spaceResults.next()) {
			space.add(mapRowToSpace(spaceResults));
		}

		return space;
	}

	private Space mapRowToSpace(SqlRowSet result) {
		Space space = new Space();

		space.setId(result.getLong("id"));
		space.setVenueId(result.getLong("venue_id"));
		space.setVenueName(result.getString("venue_name"));
		space.setName(result.getString("name"));
		space.setAccessible(result.getBoolean("is_accessible"));
		space.setOpenFrom(result.getInt("open_from"));
		space.setOpenTo(result.getInt("open_to"));
		space.setDailyRate(result.getDouble("daily_rate"));
		space.setMaxOccupancy(result.getInt("max_occupancy"));

		return space;
	}

}
