package com.techelevator.mock;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.Stock;
import com.techelevator.inventory.items.*;

public class InventoryFileMock {

	private final static String[] items = {
			"B1|Beverage Test|1.50|B",
			"A1|Appetizer Test|3.50|A",
			"E1|Entree Test|8.85|E",
			"D1|Dessert Test|2.55|D",
	};
		
	public static File getMockInventoryFile() throws IOException {
		File tmpFile = File.createTempFile("inventorytmp", ".csv");
	
		try (FileWriter writer = new FileWriter(tmpFile, true)) {
			for (String str : items) {
				writer.write(str + System.getProperty("line.separator"));
			}
		}
		return tmpFile;
	}
	
	public static int getItemCount() {
		return items.length;
	}
	
	public static Map<String, Stock> getMockInvetory() {
		Map<String, Stock> mockInventory = new LinkedHashMap<String, Stock>();
		
		mockInventory.put("B1", new Stock( new Beverage("Beverage Test", 1.50), 50));
		mockInventory.put("A1", new Stock( new Appetizer("Appetizer Test", 3.50), 50));
		mockInventory.put("E1", new Stock( new Entree("Entree Test", 8.85), 50));
		mockInventory.put("D1", new Stock( new Dessert("Dessert Test", 2.55), 50));
		
		return mockInventory;
	}
	 
}
