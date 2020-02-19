package com.techelevator.inventory;

import org.junit.*;

import com.techelevator.inventory.items.Beverage;
import com.techelevator.inventory.items.Item;

public class CartItemTest {

	private Item item;
	
	@Before
	public void createItem() {
		item = new Beverage("test", 2.50);
	}
	
	@Test
	public void calculate_total_price() throws InventoryException {
		CartItem cartItem = new CartItem(item, 10);
		
		Assert.assertEquals(25.00, cartItem.getTotalAmount(), 2);
	}
	
	@Test 
	public void able_to_add_to_quantity() throws InventoryException {
		CartItem cartItem = new CartItem(item, 1);
		cartItem.addQuantity(5);
		Assert.assertEquals(6, cartItem.getQuantity());
	}
	
	@Test 
	public void not_able_to_add_negative_to_quantity() throws InventoryException  {
		CartItem cartItem = new CartItem(item, 1);
		
		boolean exceptionThrown = false;
		try {
			cartItem.addQuantity(-5);
		} catch (InventoryException e) {
			Assert.assertEquals("Invalid Quantity", e.getMessage());
			exceptionThrown = true;
		}
		Assert.assertEquals(1, cartItem.getQuantity());
		Assert.assertTrue(exceptionThrown);
	}
	
	@Test 
	public void not_able_to_instantiate_with_negative_to_quantity() throws InventoryException  {
		
		CartItem cartItem = null;
		boolean exceptionThrown = false;
		try {
			cartItem = new CartItem(item, -1);
		} catch (InventoryException e) {
			Assert.assertEquals("Invalid Quantity", e.getMessage());
			exceptionThrown = true;
		}
		Assert.assertNull(cartItem);
		Assert.assertTrue(exceptionThrown);
	}
	
	
}
