package com.techelevator.exceptions.calc.str;

import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;

public class MainStringCalc {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		Calculator strCalc = new StringCalculator();
		
		List<String> values = menu.getValuesFromUser();

		try {
			List<String> results = strCalc.calculate(values);	
			
			for (String result : results) {
				menu.displayUserMessage(result);
			}
		} catch (NullPointerException ex) {
			System.out.println("The list was null");
		} catch (InvalidStringException e) {
			System.out.println(e.getMessage());
		}


	}

}
