package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.dao.CityDAO;
import com.techelevator.dao.model.City;

@Controller
@RequestMapping("/addCity")
@SessionAttributes( { "user", "bgClass", "city" }  ) 
public class CityAddWizardController {

	@Autowired
	private CityDAO cityDao;
	
	@RequestMapping(path="/stepOne", method=RequestMethod.GET)
	public String showStepOne() {
		return "wizard/stepOne";
	}
	
	@RequestMapping(path="/stepOne", method=RequestMethod.POST)
	public String doStepOne(ModelMap map, @RequestParam String name) {
		
		City city = new City();
		city.setName(name);
		city.setCountryCode("USA");
		
		map.addAttribute("city", city);
		
		return "redirect:/addCity/stepTwo";
	}
	
	
	@RequestMapping(path="/stepTwo", method=RequestMethod.GET)
	public String showStepTwo() {
		return "wizard/stepTwo";
	}
	
	@RequestMapping(path="/stepTwo", method=RequestMethod.POST)
	public String doStepTwo(ModelMap map, @RequestParam String state) {
		
		City city = (City) map.get("city");
		city.setDistrict(state);
	
		return "redirect:/addCity/stepThree";
	}
	
	@RequestMapping(path="/stepThree", method=RequestMethod.GET)
	public String showStepThree() {
		return "wizard/stepThree";
	}
	
	@RequestMapping(path="/stepThree", method=RequestMethod.POST)
	public String doStepThree(ModelMap map, @RequestParam int population) {
		
		City city = (City) map.get("city");
		city.setPopulation(population);
		
		return "redirect:/addCity/confirmation";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmation() {
		return "wizard/confirmation";
	}
	
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveCity(ModelMap map) {
		
		City city = (City) map.get("city");
		cityDao.save(city);
		
		return "redirect:/";
	}
	
}
