package com.techelevator.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.*;

import com.techelevator.inventory.Slot;

public class FileInventoryReaderTest {
	private static final String INVENTORY_FILE = "vendingmachine.csv"; //call caps indicates static final
	private InventoryReader reader;
	
	@Before
	public void setup() {
		reader = new FileInventoryReader(INVENTORY_FILE);
	}
	
	@Test
	public void inventory_has_correct_items() {
		
		int expectedItemCount = 16;
		
		Map<String,Slot> inventory = null;
		try {
			inventory = reader.load();
		} catch (FileNotFoundException e) {
			Assert.fail("Inventory File Not Found");
		}
		Assert.assertNotNull(inventory);
		Assert.assertEquals(expectedItemCount, inventory.size());
		
		
		Assert.assertEquals("Potato Crisps", inventory.get("A1").getItem().getName());
		Assert.assertEquals("Triplemint", inventory.get("D4").getItem().getName());
	}
	
	
	
}
