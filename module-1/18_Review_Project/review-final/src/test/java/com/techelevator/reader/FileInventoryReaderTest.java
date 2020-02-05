package com.techelevator.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.*;

import com.techelevator.inventory.Slot;

public class FileInventoryReaderTest {

	private static final String INVENTORY_FILE = "vendingmachine.csv";
	
	private InventoryReader reader;
	
	@Before
	public void setup() {
		reader = new FileInventoryReader(INVENTORY_FILE);
	}
	
	
	@Test
	public void inventory_has_correct_count_of_items() {
		
		int expectedItemCount = 16;
		
		Map<String, Slot> inventory = null;
		try {
			inventory = reader.load();
		} catch (FileNotFoundException e) {
			Assert.fail("Inventory File not found");
		}
		
		Assert.assertNotNull(inventory);
		Assert.assertEquals(expectedItemCount, inventory.size());
		
	}
	
}
