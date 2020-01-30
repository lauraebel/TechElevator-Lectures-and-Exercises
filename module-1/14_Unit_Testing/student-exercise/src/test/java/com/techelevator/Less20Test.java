package com.techelevator;

import org.junit.*;
//step 1: create a file in src/test/java named "Exercise"Test

public class Less20Test {
	
    /*
    Return true if the given non-negative number is 1 or 2 less than a multiple of 20. 
    So for example 38 and 39 return true, but 40 returns false.
    (Hint: Think "mod".)
    less20(18) → true
    less20(19) → true
    less20(20) → false
*/
	//step 2: create a variable for the class being tested
	private Less20 less20;
	
	//step 3: create a @Before method that instantiates the class being tested and assigns it to 
	//the variable from step 2
	@Before
	public void setup() {
		less20 = new Less20();
	}
	//step 4: write the tests
	@Test
	public void returns_true_for_38() {
		//arrange (often not needed)
		//act
		boolean result = less20.isLessThanMultipleOf20(38);
		//assert
		Assert.assertTrue(result);
	}
	@Test
	public void returns_true_for_39() {
		boolean result = less20.isLessThanMultipleOf20(39);
		Assert.assertTrue(result);
	}
	@Test
	public void returns_false_for_40() {
		boolean result = less20.isLessThanMultipleOf20(40);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_exact_multiple_of_20() {
		boolean result = less20.isLessThanMultipleOf20(80);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_3_less_than_multiple_of_20() {
		boolean result = less20.isLessThanMultipleOf20(77);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_5_less_than_multiple_of_20() {
		boolean result = less20.isLessThanMultipleOf20(75);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_1_more_than_multiple_of_20() {
		boolean result = less20.isLessThanMultipleOf20(41);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_2_more_than_multiple_of_20() {
		boolean result = less20.isLessThanMultipleOf20(42);
		Assert.assertFalse(result);
	}
	@Test
	public void returns_false_for_negative_multiple_of_20() {
	boolean result = less20.isLessThanMultipleOf20(-40);
	Assert.assertFalse(result);
}
}
