package com.techelevator.exceptions.calc.tax;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;

public class MainTaxCalc {

	public static void main(String[] args) {
	
		
			Menu menu = new Menu();
			Calculator salesTax = new FranklinCountyTaxCalculator();
			
			List<String> values = menu.getValuesFromUser();
			
			List<String> results = new ArrayList<String>();
			
			try {
				
			results = salesTax.calculate(values);	
			
			} catch (NumberFormatException e) {
				System.out.print("Number not in list");
				
			} catch (NullPointerException e) {
				System.out.println("Null value in list");
				
			} catch (Exception e) {
				System.out.println("unknown error" + e.getMessage());
			}
			
			for(String result :results) {
				menu.displayUserMessage(result);
			}
	}

}
