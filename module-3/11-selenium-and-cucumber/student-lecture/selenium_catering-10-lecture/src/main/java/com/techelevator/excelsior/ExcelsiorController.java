package com.techelevator.excelsior;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.excelsior.model.Reservation;
import com.techelevator.excelsior.model.Venue;

@Controller
public class ExcelsiorController {

	@Autowired
	private BookingAgent bookingAgent;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showVenues(ModelMap map) {
		List<Venue> venues = bookingAgent.getVenues();
		map.addAttribute("venues", venues);	
		return "venues";
	}
	
	@RequestMapping(path="/venueDetail", method=RequestMethod.GET)
	public String showVenueDetail( @RequestParam int venueId, ModelMap map ) {
		
		Venue venue = getVenueById(venueId);
		map.addAttribute("venue", venue);
		
		return "detail";
	}
	
	
	@RequestMapping(path="/makeReservation", method=RequestMethod.POST)
	public String makeReservation( @RequestParam int spaceId, @RequestParam int numberOfAttendees,
									@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
									@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate, 
									@RequestParam(name="reservedFor") String usersName, 
									@RequestParam int venueId) {
		
		Reservation reservation = bookingAgent.addReservation(spaceId, numberOfAttendees, startDate, endDate, usersName);
		
		System.out.println(reservation.getId());
		
		return "redirect:/reservations?venueId=" + venueId;
	}
	
	@RequestMapping(path="/reservations", method=RequestMethod.GET)
	public String showReservations( @RequestParam int venueId, ModelMap map) {
		
		List<Reservation> reservations = bookingAgent.getThirtyDayReservations(venueId);
		map.addAttribute("reservations", reservations);
		map.addAttribute("venue", getVenueById(venueId));
		
		
		return "reservations";
	}
	
	
	private Venue getVenueById(int venueId) {
		List<Venue> venues = bookingAgent.getVenues();
		Venue venue = null;
		for (Venue v : venues) {
			if (v.getId() == venueId) {
				venue = v;
			}
		}
		return venue;
	}
	
}
