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

}
