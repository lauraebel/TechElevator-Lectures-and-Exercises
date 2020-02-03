package com.techelevator.exceptions.calc.str;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;

public class StringCalculator implements Calculator {

	
	@Override
	public List<String> calculate(List<String> values) {
		
		StringReverser reverser = new StringReverser();
		List<String> results = new ArrayList<String>();
		
		for (int i = 0; i < values.size(); i++) {
			String reversed;
			reversed = reverser.reverseString(values.get(i));
			results.add(reversed);
		}
		 
		return results;
	}

	
}
