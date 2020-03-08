package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.dao.TripDAO;
import com.techelevator.dao.model.Trip;
import com.techelevator.dao.model.User;

@Controller
@SessionAttributes("user")
public class TripController {
	
	@Autowired
	private TripDAO tripDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage() {
		
		return "homePage";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String setUsername(@RequestParam String username, ModelMap map) {
		
		User user = new User();
		user.setName(username);
		
		map.addAttribute("user", user);
		
		return "redirect:/";
	}
	
	@RequestMapping(path="/addTrip", method=RequestMethod.GET)
	public String showAddTrip() {
		return "addTrip";
	}
	
	@RequestMapping(path="/addTrip", method=RequestMethod.POST)
	public String addTrip(Trip trip) {
		tripDao.save(trip);
	return "redirect:/trips";
}
	
	@RequestMapping(path="trips", method=RequestMethod.GET)
	public String viewAllTrips(ModelMap map) {
		List<Trip> listOfTrips = tripDao.getAllTrips();
		map.addAttribute("trips", listOfTrips);
		return "viewTrip";
	}
	
	
	
}
