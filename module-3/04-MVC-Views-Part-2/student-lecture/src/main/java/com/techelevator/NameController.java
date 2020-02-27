package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NameController {

	@RequestMapping("/nameList")
	public String showNames(HttpServletRequest request) {
		
		List<String> names = new ArrayList<String>();
		names.add("André");
		names.add("Matt");
		names.add("Vineeta");
		names.add("Diane");
		names.add("Apple");
		names.add("Leon");
		names.add("C.J.");
		
		/* This line adds a request attribute with the name "studentList"
		 * that contains our list of student names. This will later be
		 * used by the View (i.e. JSP) to display student names in HTML */
		request.setAttribute("nameList", names);
		
		/* This line forwards the request to the JSP */
		return "nameList";
	}
}
