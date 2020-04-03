package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.park.Park;
import com.techelevator.model.park.ParkDao;

@RestController
@RequestMapping("/api/parks")
@CrossOrigin
public class ParkController {

	@Autowired
	private ParkDao parkDao;
	
	@GetMapping
	public List<Park> list() {
		return parkDao.getAllParks();
	}
	
	@GetMapping("{parkCode}")
	public Park get(@PathVariable String parkCode) {
		return parkDao.getParkByParkCode(parkCode);
	}
	
}
