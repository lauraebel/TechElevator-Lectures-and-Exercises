package com.techelevator.inventory;

import java.util.List;

import org.junit.*;

import com.techelevator.inventory.items.Beverage;
import com.techelevator.inventory.items.Dessert;
import com.techelevator.inventory.items.Entree;

public class ShoppingCartTest {

	private CartItem[] testItems;
	
	private ShoppingCart cart;
	
	@Before
	public void setupCart() throws InventoryException {
		
		testItems = new CartItem[] {
				new CartItem(new Beverage("soda", 1.20), 10 ),
				new CartItem(new Entree("entree", 11.75), 10 )
		};
		
		cart = new ShoppingCart();
		for (CartItem item : testItems) {
			cart.add(item);
		}
	}
	
	@Test
	public void number_of_items() {
		Assert.assertEquals(2, cart.getNumberOfItems());
	}
	
	@Test
	public void get_items_from_cart() {
		List<CartItem> actual = cart.getItems();
		CartItem[] actualItems = actual.toArray( new CartItem[actual.size()] );
		Assert.assertArrayEquals(testItems, actualItems);
	}
	
	@Test
	public void add_item_to_cart() throws InventoryException {
		int expected = cart.getNumberOfItems() + 1;
		cart.add( new CartItem(new Dessert("dessert", 10), 10));
		Assert.assertEquals(expected,  cart.getNumberOfItems());
	}
	
	@Test
	public void clear_cart()  {
		List<CartItem> purchased = cart.clear();
		Assert.assertEquals(0, cart.getNumberOfItems());
		Assert.assertArrayEquals(testItems, purchased.toArray( new CartItem[purchased.size()]));
	}
	
	@Test
	public void clear_empty_cart()  {
		ShoppingCart emptyCart = new ShoppingCart();
		List<CartItem> purchased = emptyCart.clear();
		Assert.assertEquals(0, purchased.size());
		Assert.assertEquals(0, emptyCart.getNumberOfItems());
	}
	
}
