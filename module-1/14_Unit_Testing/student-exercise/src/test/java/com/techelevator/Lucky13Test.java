package com.techelevator;

import org.junit.Before;

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
}
