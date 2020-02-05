package com.techelevator.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
	
		// Get the Lines from the file
		List<String> lines = readAllLinesFromInventory();
		// Split each line into parts
		
		// Build a Slot
		
		// Add the key and the slot to the map
		
		// return the map
		
		
		return createInventoryMapFromLines(lines);
	}
	
	private Map<String, Slot> createInventoryMapFromLines(List<String> lines) {
		Map<String, Slot> inventoryMap = new LinkedHashMap<String, Slot>();
		
		for (String line : lines) {
			
			// Break each line into parts
			String[] parts = line.split("\\|");
			
			// Call the method to create the Slot from the parts
			Slot slot = createSlotFromParts(parts);
			
			// Add the Slot to the map as the value with the key 
			// of part[0] from the line ('A1', 'B2', etc.)
			inventoryMap.put(parts[0], slot);
		}
		
		return inventoryMap;
	}
	
	private Slot createSlotFromParts(String[] parts) {
		// Create a new slot 
		Slot newSlot = null;
		
		// Get the name from the line parts
		String name = parts[1];
		
		// Get the price as a double form the line pats
		double price = Double.parseDouble(parts[2]);
		
		// Get the type (Drink, Chip, etc.) from the line parts
		String type = parts[3];
		
		Item item = null;
		
		// Create an item of the subtype based on the type from the file
		if (type.equalsIgnoreCase("Chip")) {
			// If type is Chip, create new Item of type Chips
			item = new Chips(name, price);
		}
		
		if ( type.equalsIgnoreCase( "Candy")) {
			item = new Candy(name, price);
		}
		
		if ( type.equalsIgnoreCase( "Gum")) {
			item = new Gum(name, price);
		}
		
		if ( type.equalsIgnoreCase( "Drink")) {
			item = new Drink(name, price);
		}
		

		//Create the new Slot with the item
		newSlot = new Slot( item );
		
		// return the newly created slot
		return newSlot;
		
	}
	
	
	private List<String> readAllLinesFromInventory() throws FileNotFoundException {
		// A list to hold each line of the file
		List<String> lines = new ArrayList<String>();
		
		// A file object for the file
		File inventoryFile = new File( filename );
		
		// Create a scanner with the File object
		try ( Scanner fileScanner = new Scanner(inventoryFile) ) {
			
			// loop while the file has more lines of text
			while ( fileScanner.hasNextLine() ) {
				// Read the next line
				String line = fileScanner.nextLine();
				// Add the line to the List
				lines.add(line);
			}
			
		}
		
		return lines;
	}
	
	

}
