package com.techelevator.inventory.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.InvalidInventoryFileException;
import com.techelevator.inventory.Stock;
import com.techelevator.inventory.items.Appetizer;
import com.techelevator.inventory.items.Beverage;
import com.techelevator.inventory.items.Dessert;
import com.techelevator.inventory.items.Entree;
import com.techelevator.inventory.items.Item;
import com.techelevator.reader.file.FileReader;

public class CsvInventoryReader extends FileReader implements InventoryReader {

	private final static int INVENTORY_START_QUANTITY = 50;
	
	public CsvInventoryReader(File inventoryFile) {
		super(inventoryFile);
	}
	
	@Override
	public Map<String, Stock> read() throws InventoryReaderException {

		Map<String, Stock> inventory = new LinkedHashMap<String, Stock>();
		List<String> lines = new ArrayList<String>();
		
		try {
			lines = readLines();
		} catch (FileNotFoundException e) {
			throw new InventoryReaderException("File not found", e);
		}
		
		for (String line : lines) {
			String[] parts = line.split("\\|");
			inventory.put(parts[0], getStockFromLinesParts(parts));
		}
		
		return inventory;
	}
	
	private Stock getStockFromLinesParts(String[] parts)
	{
		Item item = null;
		String type = parts[3];
		String name = parts[1];
		
		double price = 0;
		try {
			price = Double.parseDouble(parts[2]);
		} catch (NumberFormatException e) {
			throw new InvalidInventoryFileException(parts[2] + " is not a valid price");
		}
		
		switch (type.toUpperCase()) {
			case "B":
				item = new Beverage(name, price);
				break;
			case "A":
				item = new Appetizer(name, price);
				break;
			case "E":
				item = new Entree(name, price);
				break;
			case "D":
				item = new Dessert(name, price);
				break;
			default:
				throw new InvalidInventoryFileException(type + " is not a valid item type");
		}
		
		return new Stock(item, INVENTORY_START_QUANTITY);
	}

}
