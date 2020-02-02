package com.techelevator;

import org.junit.*;

/*
Given an array of ints, return true if the array contains no 1's and no 3's.
GetLucky([0, 2, 4]) → true
GetLucky([1, 2, 3]) → false
GetLucky([1, 2, 4]) → false
*/

public class Lucky13Test {
	
	private Lucky13 lucky13;
	
	@Before
	public void setup() {
		lucky13 = new Lucky13();
	}
	@Test
	public void returns_false_if_contains_1_but_not_3() {
		int [] array = {0, 1, 2, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_if_contains_3_but_not_1() {
		int [] array = {0, 2, 3, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_true_if_does_not_contain_1_or_3() {
		int [] array = {0, 2, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertTrue(result);
	}
	@Test
	public void returns_true_if_contains_negative_1() {
		int [] array = {0, -1, 2, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertTrue(result);
	}
	@Test
	public void returns_true_if_contains_negative_3() {
		int [] array = {0, 2, -3, 4};
	
		boolean result = lucky13.getLucky(array);
		Assert.assertTrue(result);
	}
	@Test
	public void returns_true_if_empty_string_since_no_1_or_3() {
		int [] array = {};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertTrue(result);
	}
	@Test
	public void returns_false_if_contains_1_with_other_negative_numbers() {
		int [] array = {1, -2, -4, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_if_contains_3_with_other_negative_numbers() {
		int [] array = {-1, 2, 3, -4, 4};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_true_if_all_negative_numbers() {
		int [] array = {-1, -2, -3};
		
		boolean result = lucky13.getLucky(array);
		Assert.assertTrue(result);
		
	}
	
	
	

}
