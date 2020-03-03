package com.techelevator.excelsior.model.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.excelsior.model.Reservation;

public interface ReservationDAO {

	public Reservation addReservation(long spaceId, int numberOfAttendees, LocalDate startDate, LocalDate endDate,
			String reservedFor);

	public List<Reservation> getUpcomingReservations(Long venueId);

}
