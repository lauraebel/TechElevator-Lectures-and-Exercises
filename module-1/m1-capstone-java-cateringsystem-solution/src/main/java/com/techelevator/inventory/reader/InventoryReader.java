package com.techelevator.inventory.reader;

import java.util.Map;

import com.techelevator.inventory.Stock;

public interface InventoryReader {

	Map<String, Stock> read() throws InventoryReaderException;
}
