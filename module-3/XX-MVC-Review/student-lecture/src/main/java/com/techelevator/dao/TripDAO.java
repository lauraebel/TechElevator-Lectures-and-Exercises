package com.techelevator.dao;

import java.util.List;

import com.techelevator.dao.model.Trip;

public interface TripDAO {

	List<Trip> getAllTrips();
	void save(Trip tripe);
}
