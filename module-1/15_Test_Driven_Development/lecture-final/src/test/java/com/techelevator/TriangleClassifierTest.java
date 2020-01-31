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
		
		String type = classifier.classify(2, 2, 3);
		Assert.assertEquals("sides 1 and 2 equal", "isosceles", type);
		
		type = classifier.classify(2,  3,  2);
		Assert.assertEquals("sides 1 and 3 equal", "isosceles", type);
		
		type = classifier.classify(3,  2,  2);
		Assert.assertEquals("sides 2 and 3 are equal", "isosceles", type);
	}
	
	@Test
	public void identify_invalid_triangle_with_valid_sides() {

		String type = classifier.classify(2, 2, 5);
		Assert.assertEquals("sides 1+2<3", "invalid", type);
		
		type = classifier.classify(5, 2, 2);
		Assert.assertEquals("sides 2+3<1", "invalid", type);
		
		type = classifier.classify(2,  5,  2);
		Assert.assertEquals("sides 1+3<2", "invalid", type);
		
	}
	
}
