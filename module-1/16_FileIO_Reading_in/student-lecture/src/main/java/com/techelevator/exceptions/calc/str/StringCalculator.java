package com.techelevator.exceptions.calc.str;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.exceptions.calc.Calculator;

public class StringCalculator implements Calculator {

	
	@Override
	public List<String> calculate(List<String> values) throws InvalidStringException {
		
		StringReverser reverser = new StringReverser();
		List<String> results = new ArrayList<String>();
		
		for (int i = 0; i < values.size(); i++) {
			
			if(values.get(i) != null && values.get(i).equalsIgnoreCase("bob")) {
				throw new InvalidStringException("We don't allow", values.get(i));
			}
			String reversed = "null";
			try {
			reversed = reverser.reverseString(values.get(i));
			} catch (NullPointerException e) {
				reversed = "null";
			} finally {
			results.add(reversed);
		}
		}
		return results;
	}

	}

