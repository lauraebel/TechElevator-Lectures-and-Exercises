package com.techelevator;

public class KataFizzBuzz {
	//If the number is divisible by 3, convert the number to the string, "Fizz".
	//If the number is divisible by 5, convert the number to the string, "Buzz".
	//If the number is divisible by 3 AND 5, convert the number to the string, "FizzBuzz"
	//For all other numbers between 1 and 100 (inclusive), simply convert the number to a string.
	//Any number that is not between 1 and 100 (inclusive), convert the number to an empty string.
	
	//If the number is divisible by 3, OR contains a 3, convert the number to the string, "Fizz".
	//If the number is divisible by 5, OR contains a 5, convert the number to the string, "Buzz".
	//If the number is divisible by 3 AND 5, OR contains a 3 AND 5, 
	//convert the number to the string, "FizzBuzz"
	
	public String getKata(int num) {
		if(((num%3 == 0) && (num%5 != 0) && ((!String.valueOf(num).contains("5"))) || ((String.valueOf(num).contains("3"))))) {
			return "Fizz";
		} else if (((num%5 == 0) && (num%3 != 0)) && ((!String.valueOf(num).contains("3"))) || ((String.valueOf(num).contains("5")))) {
			return "Buzz";
		} else if ((num%3 == 0) && (num%5 == 0)) {
			return "FizzBuzz";
		} else if ((num%3 != 0) && (num%5 != 0) && (num >= 1) && (num <= 100)) {
			return String.valueOf(num);
		} else if ((num%3 != 0) && (num%5 != 0) && (num > 100)) {
			return "";
		} else if ((num%3 != 0) && (num%5 != 0) && (num < 1)) {
			return "";
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
