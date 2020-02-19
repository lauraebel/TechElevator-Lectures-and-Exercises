package com.techelevator.mock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InvalidPriceInventoryFileMock {

	private final static String[] items = {
			"B1|Beverage Test|zzz|B",
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
	
}
