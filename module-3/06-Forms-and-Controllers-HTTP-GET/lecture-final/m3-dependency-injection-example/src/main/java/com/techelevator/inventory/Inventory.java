package com.techelevator.inventory;

import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.items.Item;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.InventoryReaderException;

public class Inventory {

	private Map<String, Stock> items = new LinkedHashMap<String, Stock>();
	
	public Inventory(InventoryReader reader) throws InventoryReaderException {
		items = reader.read();
	}
	
	public Map<String, Stock> getStock() {
		return items;
	}
	
	public Item peekItemFromInventory(String itemCode) throws InventoryException {
		if (doesItemExist(itemCode.toUpperCase())) {
			return items.get(itemCode.toUpperCase()).getItem();
		} else {
			throw new InventoryException("Item does not exist", itemCode, 0);
		}
	}

	public Item getItemFromInventory(String itemCode, int quantity) throws InventoryException {
		
		if (!doesItemExist(itemCode.toUpperCase())) {
			throw new InventoryException("Item does not exist", itemCode, quantity);
		}
		
		Stock stock = items.get(itemCode.toUpperCase());
		
		if (stock.isSoldOut()) {
			throw new InventoryException("Item Sold Out", itemCode, quantity);
		}
		
		if (!stock.removeQuanity(quantity)) {
			throw new InventoryException("Invalid Quantity", itemCode, quantity);
		}
		
		return stock.getItem();
	}
	
	private boolean doesItemExist(String itemCode) {
		return items.containsKey(itemCode.toUpperCase());
	}
	
}
