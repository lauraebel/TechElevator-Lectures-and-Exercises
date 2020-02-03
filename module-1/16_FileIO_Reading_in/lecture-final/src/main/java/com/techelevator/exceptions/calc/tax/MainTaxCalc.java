package com.techelevator.exceptions.calc.tax;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;

public class MainTaxCalc {

	public static void main(String[] args) {
	
		
			Menu menu = new Menu();
			Calculator salesTax = new FranklinCountyTaxCalculator();
			
			while (true) {
				
				List<String> values = menu.getValuesFromUser();
	
				List<String> results = new ArrayList<String>();
				
				try {
					results = salesTax.calculate(values);	
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid value in list");
				} catch (NullPointerException e) {
					System.out.println("Null value in list");
				} catch (Exception e) {
					System.out.println("Unknown error occurred " + e.getMessage());
				}
				
			
				for (String result : results) {
					menu.displayUserMessage(result);
				}
			
			}
	
	}

}
