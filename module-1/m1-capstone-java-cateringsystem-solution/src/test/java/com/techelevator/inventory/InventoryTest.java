package com.techelevator.inventory;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import com.techelevator.inventory.items.Item;
import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.InventoryReaderException;
import com.techelevator.mock.InventoryFileMock;

public class InventoryTest {

	private Inventory inventory;
	
	@Before
	public void setup() throws IOException, InventoryReaderException {
		File mockInventoryFile = InventoryFileMock.getMockInventoryFile();
		InventoryReader reader = new CsvInventoryReader(mockInventoryFile);
		inventory = new Inventory(reader);
	}
	
	@Test
	public void get_item_from_inventory()  {
		Stock testStock = InventoryFileMock.getMockInvetory().get("A1");
		Item actualItem = null;
		try {
			actualItem = inventory.getItemFromInventory("A1", 10);
		} catch (InventoryException e) {
			Assert.fail("Fail to retrieve item " + e.getItemCode() + ": " + e.getMessage());
		}
		
		Assert.assertNotNull(actualItem);
		Assert.assertEquals(testStock.getItem(), actualItem);
			
	}
	
	@Test
	public void unable_to_get_item_from_inventory_that_does_not_exist()  {
		boolean exceptionThrown = false;
		Item actualItem = null;
		try {
			actualItem = inventory.getItemFromInventory("Z100", 10);
		} catch (InventoryException e) {
			Assert.assertEquals("Item does not exist", e.getMessage());
			Assert.assertEquals("Z100", e.getItemCode());
			Assert.assertEquals(10, e.getQuantityToRemove());
			exceptionThrown = true;
		}
		Assert.assertNull(actualItem);
		Assert.assertTrue(exceptionThrown);	
	}
	
	@Test
	public void unable_to_get_item_from_inventory_when_sold_out()  {
		boolean exceptionThrown = false;
		Item actualItem = null;
		
		try {
			Assert.assertNotNull(inventory.getItemFromInventory("A1", 50));
			actualItem = inventory.getItemFromInventory("A1", 10);
		} catch (InventoryException e) {
			Assert.assertEquals("Item Sold Out", e.getMessage());
			Assert.assertEquals("A1", e.getItemCode());
			Assert.assertEquals(10, e.getQuantityToRemove());
			exceptionThrown = true;
		}
		Assert.assertNull(actualItem);
		Assert.assertTrue(exceptionThrown);	
	}
	
	@Test
	public void unable_to_get_item_from_inventory_not_enough_quantity_remains()  {
		boolean exceptionThrown = false;
		Item actualItem = null;
		
		try {
			Assert.assertNotNull(inventory.getItemFromInventory("A1", 40));
			actualItem = inventory.getItemFromInventory("A1", 20);
		} catch (InventoryException e) {
			Assert.assertEquals("Invalid Quantity", e.getMessage());
			Assert.assertEquals("A1", e.getItemCode());
			Assert.assertEquals(20, e.getQuantityToRemove());
			exceptionThrown = true;
		}
		Assert.assertNull(actualItem);
		Assert.assertTrue(exceptionThrown);	
	}
	
	@Test
	public void can_peek_items_from_inventory() throws InventoryException {
		
		Item expectedItem = InventoryFileMock.getMockInvetory().get("A1").getItem();
		Item actualItem = inventory.peekItemFromInventory("A1");
		
		Assert.assertNotNull(actualItem);
		Assert.assertEquals(expectedItem, actualItem);

	}
	
	@Test
	public void can_not_peek_invalid_items_from_inventory()  {
		
		Item actualItem = null;
		boolean exceptionThrown = false;
		try {
			actualItem = inventory.peekItemFromInventory("Z10");
		} catch (InventoryException e) {
			exceptionThrown = true;
		}
		
		Assert.assertNull(actualItem);
		Assert.assertTrue(exceptionThrown);

	}
	
}
