package com.techelevator.inventory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.mock.InventoryFileMock;

public class StockTest {

	private Stock stock;
	
	@Before
	public void createTestStock() {
		stock = InventoryFileMock.getMockInvetory().get("A1");
	}
	
	@Test
	public void starting_quantity_is_correct() {
		Assert.assertEquals(50, stock.getQuantity());
	}
	
	@Test
	public void item_is_correct() {
		Assert.assertEquals(InventoryFileMock.getMockInvetory().get("A1").getItem(), stock.getItem());
	}
	
	@Test
	public void able_to_remove_quantity() {
		Assert.assertTrue(stock.removeQuanity(10));
		Assert.assertEquals(40, stock.getQuantity());
	}
	
	@Test
	public void not_able_to_remove_more_than_remaining_quantity() {
		Assert.assertFalse(stock.removeQuanity(51));
		Assert.assertEquals(50, stock.getQuantity());
	}
	
	@Test
	public void able_to_remove_all_remaining_quantity() {
		Assert.assertTrue(stock.removeQuanity(50));
		Assert.assertEquals(0, stock.getQuantity());
	}
	
	@Test
	public void is_not_sold_out() {
		Assert.assertTrue(stock.removeQuanity(49));
		Assert.assertFalse(stock.isSoldOut());
	}
	
	@Test
	public void is_sold_out() {
		Assert.assertTrue(stock.removeQuanity(50));
		Assert.assertTrue(stock.isSoldOut());
	}
	
}
