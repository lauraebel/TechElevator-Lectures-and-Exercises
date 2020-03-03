package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.ReviewDao;

@Controller
public class HelloController {
	
	@Autowired
	private ReviewDao reviewDao;

	@RequestMapping("/homePage")
	public String showHomePage() {
		return "homePage";
	}
}
