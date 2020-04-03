package com.techelevator.model.park;

import java.util.List;

public interface ParkDao {

	List<Park> getAllParks();
	Park getParkByParkCode(String parkCode);
}
