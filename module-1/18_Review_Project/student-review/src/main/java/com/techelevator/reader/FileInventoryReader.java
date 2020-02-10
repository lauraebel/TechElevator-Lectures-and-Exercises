package com.techelevator.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.Candy;
import com.techelevator.inventory.Chips;
import com.techelevator.inventory.Drink;
import com.techelevator.inventory.Gum;
import com.techelevator.inventory.Item;
import com.techelevator.inventory.Slot;

public class FileInventoryReader implements InventoryReader {
	
	private String filename;
	
	public FileInventoryReader(String filename) {
		this.filename = filename;
	}

	@Override
	public Map<String, Slot> load() throws FileNotFoundException {
		
		// get the lines from the file
		List<String> lines = readAllLinesFromInventory();
		
		//spilt each line into parts
		
		//build a slot
		
		//add the key and slot into map
		
		//return the map
		
		return createInventoryMapFromLines(lines);
	}
	
	private Map<String, Slot> createInventoryMapFromLines(List<String> lines) {
		Map<String, Slot> inventoryMap = new HashMap<String,Slot>();
		
		for (String line :lines) {
			String [] parts = line.split("\\|");
			Slot slot = new Slot(new Item("", 0d, ""));
			inventoryMap.put(line, slot);
		}
		
		return inventoryMap;
	}
	
	private Slot createsSlotFromParts(String[] parts) {
		//create slot
		Slot newSlot = null;
		//get name from line parts
		String name = parts[1];
		//get price as double from line parts
		double price = Double.parseDouble(parts[2]);
		//get the type from the line parts
		String type = parts[3];
		
		Item item = null;
		
		if (type.equalsIgnoreCase("Chip")) {
			//if type is chip create new item of type chips
			item = new Chips(name, price);
			
		}
		if (type.equalsIgnoreCase("Candy")) {
			item = new Candy(name, price);
			
		}
		if (type.equalsIgnoreCase("Gum")) {
			item = new Gum(name, price);

		}
		if (type.equalsIgnoreCase("Drink")) {
			item = new Drink(name, price);
		}
		newSlot = new Slot(item);
		return newSlot;
	}
	
	private List<String> readAllLinesFromInventory() throws FileNotFoundException {
		//a list to hold each line of the file
		List<String> lines = new ArrayList<String>();
		
		//a file object for the file
		File inventoryFile = new File(filename);
		
		//create a scanner with the file object
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			
			//loop while the file has more lines of text
			while(fileScanner.hasNextLine()) {
				
				//read the next line
				String line = fileScanner.nextLine();
				
				//add line to list
				lines.add(line);
			}
			
		}
		
		
		return lines;
	}

}
