package com.techelevator.excelsior.model.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.excelsior.model.Space;

public interface SpaceDAO {

	public List<Space> getSpacesByVenueId(long venueId);

	public List<Space> getAllAvailableSpaces(LocalDate startDate, LocalDate endDate, int numberOfAttendees,
			boolean isAccessible, double dailyRate, int category);

	List<Space> getAvailableSpacesForVenue(long venueId, LocalDate startDate, LocalDate endDate, int numberOfAteendees);

}
