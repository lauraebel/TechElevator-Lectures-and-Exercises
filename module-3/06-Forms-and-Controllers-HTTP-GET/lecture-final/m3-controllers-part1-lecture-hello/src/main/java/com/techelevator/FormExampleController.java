package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormExampleController {

	
	@RequestMapping("/formExample")
	public String showForm(HttpServletRequest request) {
		
		return "formExample";
	}
	
	@RequestMapping("/formExampleSubmission")
	public String processForm(HttpServletRequest request) {
		
		String usersFirstName = request.getParameter("firstName");
		String usersLastName = request.getParameter("lastName");
		String usersSelectedColor = request.getParameter("selectedColor");
		
		System.out.println("usersFirstName="+ usersFirstName);
		System.out.println("usersLastName="+ usersLastName);
		System.out.println("usersSelectedColor="+ usersSelectedColor);
		
		
		request.setAttribute("fName", usersFirstName);
		request.setAttribute("lName", usersLastName);
		request.setAttribute("selColor", usersSelectedColor);
		
		return "formExampleResult";
	}
	
}
