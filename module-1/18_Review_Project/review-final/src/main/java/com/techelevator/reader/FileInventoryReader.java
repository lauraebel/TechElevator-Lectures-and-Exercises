package com.techelevator.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
		Map<String, Slot> inventoryMap = new HashMap<String, Slot>();
		
		for (String line : lines) {
			Slot slot = new Slot( new Item("", 0d, ""));
			inventoryMap.put(line, slot);
		}
		
		return inventoryMap;
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
