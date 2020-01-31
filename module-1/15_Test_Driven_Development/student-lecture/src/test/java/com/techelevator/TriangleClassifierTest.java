package com.techelevator;

import org.junit.*;

public class TriangleClassifierTest {
	
	private TriangleClassifier classifier;
	
	@Before
	public void setup() {
		classifier = new TriangleClassifier();
	}
	
	@Test
	public void identify_equilateral_triangle() {
		String type = classifier.classify(4, 4, 4);
		Assert.assertEquals("equilateral", type);
	}
	
	@Test
	public void identify_scalene_triangle() {
		String type = classifier.classify(2, 3, 4);
		Assert.assertEquals("scalene", type);
	}
	
	@Test
	public void identify_isosceles_triangle() {
		// 1 == 2, but not 3
		// 1 == 3, but not 2
		// 2 == 3, but not 1
		
		String type = classifier.classify(2, 2, 3);
		Assert.assertEquals("sides 1 and 2 equal",  "isosceles", type);
		
		type = classifier.classify(2, 3, 2);
		Assert.assertEquals("sides 1 and 3 equal", "isosceles", type);
	
		type = classifier.classify(3, 2, 2);
		Assert.assertEquals("sides 2 and 3 equal", "isosceles", type);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
