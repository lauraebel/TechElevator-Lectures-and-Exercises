package com.techelevator.calculator;

public class Calculator {

	private int result = 0;

	public int add(int addend) {
		result += addend;
		return result;
	}
	
	public int getResult() {
		return result;
	}
	
	public int multiply(int multiplier) {
		result *= multiplier;
		return result;
	}
	
	public int power(int exponent) {
		if (exponent < 0) {
			result = (int) Math.pow(result, exponent);
			return Math.abs(result);
		} else {
			result = (int) Math.pow(result, exponent);
			return result;
		}
	}
	
	public void reset() {
		result = 0;
	}
	
	public int subtract(int subtrahend) {
		result -= subtrahend;
		return result;
	}
}

		
		
	

