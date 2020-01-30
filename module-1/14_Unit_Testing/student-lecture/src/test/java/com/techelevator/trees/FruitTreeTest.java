package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {
	
	private FruitTree fruitTree;
	
	@Before
	public void setup() {
		fruitTree = new FruitTree("Pear", 10); //values from constructor in FruitTree Class
	}
	
	@Test
	public void pick_2_fruit() {
		//arrange
		//don't have one here
		
		//act
		boolean success = fruitTree.pickFruit(2);
		
		//assert
		Assert.assertTrue(success);
		
		Assert.assertEquals(8, fruitTree.getPiecesOfFruitLeft());
		
	}
	
	@Test
	public void pick_half_fruit_then_more_than_remaining() {
		//arrange
		fruitTree.pickFruit(5); //half of the 10 from the constructor above
		
		//act
		boolean success = fruitTree.pickFruit(6); //more than on the tree
		
		//Assert
		Assert.assertFalse(success);
		Assert.assertEquals(5, fruitTree.getPiecesOfFruitLeft()); //5 because when we tried to
		//pick 6 more, it returned false so we only picked 5
		
	}
	
	@Test 
	public void correct_type_of_fruit() {
		Assert.assertEquals("Pear", fruitTree.getTypeOfFruit());
	}
	
	@Test
	public void cannot_pick_negative_fruit() {
		//act
		fruitTree.pickFruit(-5);
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
		//this test fails but is accurate. In the real world you would need to change the code
		//because logically you cannot pick negative fruit off a tree
	}
	

}
