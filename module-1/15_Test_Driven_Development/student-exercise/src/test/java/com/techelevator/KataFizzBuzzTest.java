package com.techelevator;

import org.junit.*;

	//If the number is divisible by 3, convert the number to the string, "Fizz".
	//If the number is divisible by 5, convert the number to the string, "Buzz".
	//If the number is divisible by 3 AND 5, convert the number to the string, "FizzBuzz"
	//For all other numbers between 1 and 100 (inclusive), simply convert the number to a string.
	//Any number that is not between 1 and 100 (inclusive), convert the number to an empty string.

//If the number is divisible by 3, OR contains a 3, convert the number to the string, "Fizz".
//If the number is divisible by 5, OR contains a 5, convert the number to the string, "Buzz".
//If the number is divisible by 3 AND 5, OR contains a 3 AND 5, 
//convert the number to the string, "FizzBuzz"
public class KataFizzBuzzTest {
	
	private KataFizzBuzz fizzbuzz;
	
	@Before
	public void setup() {
		fizzbuzz = new KataFizzBuzz();
	}
	@Test
	public void three_is_divisible_by_3_and_returns_fizz() {
		String katafb = fizzbuzz.getKata(3);
		Assert.assertEquals("Fizz", katafb);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
