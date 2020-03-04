package com.techelevator;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/favoriteThings")
@SessionAttributes({})
public class FavoriteThingsController {

	@RequestMapping(path="/Page1", method=RequestMethod.GET)
	public String showPage1() {
		return "favoriteThings/Page1";
	}
}
