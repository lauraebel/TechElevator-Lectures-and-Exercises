package com.techelevator.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.Slot;

public interface InventoryReader {

	Map<String, Slot> load() throws FileNotFoundException;
}
