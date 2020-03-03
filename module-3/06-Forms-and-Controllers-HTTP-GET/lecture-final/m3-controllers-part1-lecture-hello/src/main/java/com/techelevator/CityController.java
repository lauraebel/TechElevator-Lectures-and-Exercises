package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.city.City;
import com.techelevator.model.city.CityDAO;

@Controller
public class CityController {

	@Autowired
	private CityDAO cityDao;
	
	@RequestMapping("/citySearch")
	public String showCitySearch() {
		return "city/search";
	}
	
	@RequestMapping("/searchResult")
	public String displaySearchResults(HttpServletRequest request) {
		String countryCode = request.getParameter("countryCode");
		
		List<City> cityList = cityDao.findCityByCountryCode(countryCode);
		
		request.setAttribute("cities", cityList);
		
		return "city/result";
	}
	
}
