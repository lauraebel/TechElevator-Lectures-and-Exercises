package com.techelevator.inventory.reader;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.*;

import com.techelevator.inventory.InvalidInventoryFileException;
import com.techelevator.inventory.Stock;
import com.techelevator.mock.InvalidItemTypeInventoryFileMock;
import com.techelevator.mock.InvalidPriceInventoryFileMock;
import com.techelevator.mock.InventoryFileMock;

public class CsvInventoryReaderTest {

	private InventoryReader reader;
	
	@Before
	public void setup() throws IOException {
		File file = InventoryFileMock.getMockInventoryFile();
		reader = new CsvInventoryReader(file);
	}
	
	@Test
	public void verify_inventory_read() {
		Map<String, Stock> inventory = null;
		try {
			inventory = reader.read();
		} catch (InventoryReaderException e) {
			Assert.fail("Failed to reader Inventory file: " + e.getMessage());

		}
		
		Assert.assertNotNull("Inventory returned null", inventory);
		Assert.assertEquals("Invalid inventory size: expected " + InventoryFileMock.getItemCount() + " but was " + inventory.size(), 
				InventoryFileMock.getItemCount(), 
				inventory.size());
		
		assertInventoryMapsEqual(InventoryFileMock.getMockInvetory(), inventory);
	}
	
	@Test
	public void verify_invalid_price_exception() throws IOException {
		File file = InvalidPriceInventoryFileMock.getMockInventoryFile();
		reader = new CsvInventoryReader(file);
		Map<String, Stock> inventory = null;
		boolean exceptionThrown = false;
		try {
			inventory = reader.read();
		} catch (InvalidInventoryFileException e) {
			exceptionThrown = true;
			Assert.assertEquals("zzz is not a valid price", e.getMessage());
			
		} catch (InventoryReaderException e) {
			Assert.fail("Failed to reader Inventory file: " + e.getMessage());
		}
		
		Assert.assertNull(inventory);
		Assert.assertTrue(exceptionThrown);
		
	}
	
	@Test
	public void verify_invalid_item_type_exception() throws IOException {
		File file = InvalidItemTypeInventoryFileMock.getMockInventoryFile();
		reader = new CsvInventoryReader(file);
		Map<String, Stock> inventory = null;
		boolean exceptionThrown = false;
		try {
			inventory = reader.read();
		} catch (InvalidInventoryFileException e) {
			exceptionThrown = true;
			Assert.assertEquals("Z is not a valid item type", e.getMessage());
			
		} catch (InventoryReaderException e) {
			Assert.fail("Failed to reader Inventory file: " + e.getMessage());
		}
		
		Assert.assertNull(inventory);
		Assert.assertTrue(exceptionThrown);
		
	}
	
	
	private void assertInventoryMapsEqual(Map<String, Stock> expected, Map<String, Stock> actual) {
		for (Entry<String, Stock> entry : expected.entrySet()) {
			Assert.assertTrue("Actual does not contain key " + entry.getKey(), actual.containsKey( entry.getKey() ));
			Assert.assertEquals( "Stock for key " + entry.getKey() + " are not equal",entry.getValue() , actual.get(entry.getKey() ));
			Assert.assertEquals( "Item for key " + entry.getKey() + " are not equal", entry.getValue().getItem(), actual.get(entry.getKey()).getItem());
		}
	}
	
}
