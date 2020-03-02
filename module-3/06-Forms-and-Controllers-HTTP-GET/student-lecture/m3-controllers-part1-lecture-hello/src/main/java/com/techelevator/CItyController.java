package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.city.City;
import com.techelevator.model.city.CityDAO;

@Controller //tells Spring that it is a Controller

public class CItyController {

@Autowired
private CityDAO cityDao;
	
@RequestMapping("/citySearch")  //defines what the URL will do
	public String showCitySearch() {
		return "city/search"; //Logical View Name from \WEB-INF\jsp\city\search.jsp and flips slash from \ to /
}

@RequestMapping("/searchResult") //to find out where to submit to in the search.jsp
	public String displaySearchResults(HttpServletRequest request) { //pass in the request to the servlet
	String countryCode = request.getParameter("countryCode"); //getParameter allows query parameter in the URL
		
	List<City> cityList = cityDao.findCityByCountryCode(countryCode);
	
	request.setAttribute("cities", cityList); //Attributes can be any object not just strings, ints, etc.
	
	return "city/result"; //from result.jsp
}
}
