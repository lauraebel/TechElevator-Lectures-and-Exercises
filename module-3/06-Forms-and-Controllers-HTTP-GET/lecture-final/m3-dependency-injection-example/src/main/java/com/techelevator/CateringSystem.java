package com.techelevator;

import java.util.Map;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Stock;

public class CateringSystem {


	private Inventory inventory;

	
	public CateringSystem(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Map<String, Stock> getStock() {
		return inventory.getStock();
	}
		
	
	
}
