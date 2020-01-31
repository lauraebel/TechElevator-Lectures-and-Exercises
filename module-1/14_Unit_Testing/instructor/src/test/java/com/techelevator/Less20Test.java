package com.techelevator;

import org.junit.*;

// Step 1 create a file in src/test/java named "Exercise"Test
public class Less20Test {
	
	// Step 2: Create a variable for the class being tested
	private Less20 less20;
	
	// Step 3: Create a @Before method that instantiates that class being tested
	// and assigns it to the variable created in step 2
	@Before
	public void setup() {
		less20 = new Less20();
	}
	
	// Step 4: write your tests
	@Test
	public void returns_true_for_38() {
		// Arrange (optional)
		// Act
		boolean result = less20.isLessThanMultipleOf20( 38 );
		// Assert
		Assert.assertTrue( result );
	}
	

	
	
}
