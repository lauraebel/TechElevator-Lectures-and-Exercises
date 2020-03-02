package com.techelevator.fbn.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.fbn.model.MortgageLoanEstimate;

/* The @Controller annotation will make the Spring container aware
 * of this controller as a managed bean. Controllers in Spring Web
 * MVC are just plain old Java objects that are annotated to indicate
 * that they are an MVC controller
 *
 * The @Controller annotation indicates to the Spring framework
 * that this class should be treated as a controller
 *
 * The <component-scan> element in springmvc-servlet.xml causes
 * Spring to look at all of the classes in the package specified
 * and look for classes with this annotation. This controller will
 * be found during the Spring component scan during application
 * startup.
 *
 * Controllers (and pretty much everything else in Spring) can also be
 * configured using XML.  However, annotations have become the
 * suggested way of wiring together a Spring application. */
@Controller
public class PaymentCalculatorController {

	/* The @RequestMapping annotation is used to map resource paths to
	 * method calls.
	 *
	 * This particular mapping says that any requests for the root
	 * should invoke this method.
	 *
	 * All controller request handling methods should return a String
	 * that represents the "logical view name" */
	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {

		/* Controller methods can return a variety of types of values,
		 * but we will be using `String`.  The value of the returned
		 * String is the *logical view name* to render.  The default
		 * implementation is to map the logical view name directly to
		 * a file, however we configured a different View Resolver
		 * that maps logical view names to JSP files under WEB-INF/jsp
		 * See springmvc-servlet.xml for details. */
		return "mortgageCalculatorInput";
	}

	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(
			/* If you want to take parameters from the user, you can add those parameters
			 * to the arguments of the controller method with the `@RequestParam`
			 * annotation. This will take those parameters, convert them to the
			 * proper type and assign them to these variables. */
			@RequestParam BigDecimal loanAmount, @RequestParam int loanTerm, @RequestParam BigDecimal rate,
			/* For everything you give back to the JSP, put it into a `ModelMap` object
			 * that you can specify in the arguments. Spring will create a give you
			 * this object, so that anything you add to it will be made available to
			 * the JSP that the controller sends to the user. */
			ModelMap modelHolder) {

		MortgageLoanEstimate calculator = new MortgageLoanEstimate(loanAmount, loanTerm, rate);

		/* Send the object in the `calculator` variable to the JSP. In the JSP, the
		 * object will be called "estimate" */
		modelHolder.put("estimate", calculator);

		/* Display the `mortgageCalculatorResult.jsp` */
		return "mortgageCalculatorResult";
	}
}
