package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {

	private FruitTree fruitTree;
	
	@Before
	public void setup() {
		fruitTree = new FruitTree("Pear", 10);
	}
	
	@Test
	public void pick_2_fruit() {
		
		// Arrange
		
		// Act
		boolean success = fruitTree.pickFruit( 2 );
		
		// Assert
		Assert.assertTrue( success );
		
		Assert.assertEquals( 8 ,  fruitTree.getPiecesOfFruitLeft() );
		
	}
	
	
	@Test
	public void pick_half_fruit_then_more_than_remaining() {
		
		// Arrange
		fruitTree.pickFruit( 5 );
		
		// Act
		boolean success = fruitTree.pickFruit( 6 );
		
		// Assert
		Assert.assertFalse( success );
		Assert.assertEquals(5, fruitTree.getPiecesOfFruitLeft() );
		
	}
	
	@Test 
	public void correct_type_of_fruit() {
		Assert.assertEquals("Pear", fruitTree.getTypeOfFruit());
	}
	
	@Test
	public void cannot_pick_negative_fruit() {
		fruitTree.pickFruit( - 5 );
		Assert.assertEquals( 10, fruitTree.getPiecesOfFruitLeft());
	}
	
}
