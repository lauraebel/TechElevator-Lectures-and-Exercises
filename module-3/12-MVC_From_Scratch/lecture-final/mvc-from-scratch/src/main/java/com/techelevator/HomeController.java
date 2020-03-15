package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.City;
import com.techelevator.model.Country;
import com.techelevator.model.dao.CityDao;
import com.techelevator.model.dao.CountryDao;

@Controller
public class HomeController {

	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@RequestMapping("/")
	public String showHomePage(ModelMap map, @RequestParam(required=false) String country) {
		
		
		List<Country> countries = countryDao.getAllCountries();
		map.addAttribute("countries", countries);
		
		if (country != null) {
			List<City> cities = cityDao.getAllCitiesByCountryCode(country);
			map.addAttribute("cities", cities);
		}
		
		
		return "homePage";
	}
	
}
