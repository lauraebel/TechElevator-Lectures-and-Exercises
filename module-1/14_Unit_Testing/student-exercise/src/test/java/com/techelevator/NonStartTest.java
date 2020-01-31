package com.techelevator;

import org.junit.*;

/*
Given 2 strings, return their concatenation, except omit the first char of each. The strings will
be at least length 1.
GetPartialString("Hello", "There") → "ellohere"
GetPartialString("java", "code") → "avaode"
GetPartialString("shotl", "java") → "hotlava"
*/

public class NonStartTest {
	
	private NonStart nonstart;
	
	@Before 
	public void setup() {
		nonstart = new NonStart();
	}

}
