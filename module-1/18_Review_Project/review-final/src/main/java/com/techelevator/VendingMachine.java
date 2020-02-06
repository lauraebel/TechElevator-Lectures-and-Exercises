package com.techelevator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.Slot;
import com.techelevator.reader.FileInventoryReader;
import com.techelevator.reader.InventoryReader;

public class VendingMachine {

	private Map<String, Slot> inventory = new LinkedHashMap<String, Slot>();
	
	public VendingMachine(String filename) throws FileNotFoundException {
		InventoryReader reader = new FileInventoryReader(filename);
		this.inventory = reader.load();
	}
	
	public Map<String, Slot> getInventory() {
		return this.inventory;
	}
	
}
