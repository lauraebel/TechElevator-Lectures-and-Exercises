package com.techelevator;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/FavoriteThings")
@SessionAttributes({"animal", "car", "dance"})
public class FavoriteThingsController {

	@RequestMapping(path="/Page1", method=RequestMethod.GET)
	public String showPage1() {
		return "Page1";
	}
	
	@RequestMapping(path="/Page1", method=RequestMethod.POST)
	public String page1Favorite(ModelMap map, @RequestParam String animal) {
		map.addAttribute("animal", animal);
		return "redirect:/FavoriteThings/Page2";
	}
	
	@RequestMapping(path="/Page2", method=RequestMethod.GET)
	public String showPage2() {
		return "Page2";
	}
	
	@RequestMapping(path="/Page2", method=RequestMethod.POST)
	public String page2Favorite(ModelMap map, @RequestParam String car) {
		map.addAttribute("car", car);
		return "redirect:/FavoriteThings/Page3";
	}
	
	@RequestMapping(path="/Page3", method=RequestMethod.GET)
	public String showPage3() {
		return "Page3";
	}
	
	@RequestMapping(path="/Page3", method=RequestMethod.POST)
	public String page3Favorites(ModelMap map, @RequestParam String dance) {
		map.addAttribute("dance", dance);
		return "redirect:/FavoriteThings/Confirmation";
	}
	
	@RequestMapping(path="/Confirmation", method=RequestMethod.GET)
	public String showConfirmation() {
		return "Confirmation";
	}
	
}
