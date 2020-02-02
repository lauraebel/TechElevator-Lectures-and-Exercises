package com.techelevator;

import org.junit.*;

/*
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
whatever is there if the string is less than length 3. Return n copies of the front;
frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"
*/

public class FrontTimesTest {
	
	private FrontTimes frontTimes;
	
	@Before
	public void setup() {
		frontTimes = new FrontTimes();
	}
	@Test 
	public void returns_first_3_letters_4_times_if_string_longer_than_3_and_int_is_4() {
		String result = frontTimes.generateString("Hello", 4);
		Assert.assertEquals("HelHelHelHel", result);
	}
	@Test
	public void returns_first_3_letters_6_times_if_string_longer_than_10_and_int_is_6() {
		String result = frontTimes.generateString("Congratulations", 6);
		Assert.assertEquals("ConConConConConCon", result);
	}
	@Test
	public void returns_both_letters_3_times_if_string_is_2_letters_and_int_is_3() {
		String result = frontTimes.generateString("Hi", 3);
		Assert.assertEquals("HiHiHi", result);
	}
	@Test
	public void returns_letter_4_times_if_string_is_1_letter_and_int_is_4() {
		String result = frontTimes.generateString("A", 4);
		Assert.assertEquals("AAAA", result);
	}
	@Test
	public void returns_empty_string_if_string_has_no_letters_regardless_of_int() {
		String result = frontTimes.generateString("", 4);
		Assert.assertEquals("", result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
