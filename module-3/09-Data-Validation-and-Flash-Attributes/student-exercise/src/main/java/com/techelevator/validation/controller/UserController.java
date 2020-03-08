package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	@RequestMapping(path="/newUser", method=RequestMethod.GET)
	public String showNewUserRegistration(ModelMap map) {
			map.addAttribute("registration", new Registration());			
		return "newUser";
	}

	@RequestMapping(path="/newUser", method=RequestMethod.POST)
	public String addNewUser(@Valid @ModelAttribute("registration") Registration newRegistration, BindingResult result) {

		if(result.hasErrors()) {
			return "newUser";
		}
		return "redirect:/newUserConfirm";
	}
		
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginScreen(ModelMap map) {
		map.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String performLogin(@Valid @ModelAttribute("login") Login newLogin, BindingResult result) {
	
		if(result.hasErrors()) {
			return "login";
		}
		return "redirect:/loginSuccess";
	}
	
	@RequestMapping(path="/loginSuccess", method=RequestMethod.GET)
	public String showLoginSuccessPage(ModelMap map) {
		return "loginSuccess";
	}

	@RequestMapping(path="/newUserConfirm", method=RequestMethod.GET)
	public String showNewUserConfirmation(ModelMap map) {
		return "newUserConfirm";
	}
	

}
