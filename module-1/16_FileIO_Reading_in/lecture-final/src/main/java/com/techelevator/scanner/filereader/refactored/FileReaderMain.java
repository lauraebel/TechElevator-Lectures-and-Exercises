package com.techelevator.scanner.filereader.refactored;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderMain {

	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		// Get the File from the user
		File file = menu.getFileFromUser();
		
		// Get the line count from the user
		int lineCount = menu.getLineCountFromUser();
		
		// Reader the file
		FileReader reader = new TextFileReader(file);
		List<String> lines = new ArrayList<String>();
		
		try {
			lines = reader.read(lineCount);
		} catch (FileNotFoundException e) {
			menu.displayMessage("File not found: " + file.getAbsolutePath());
		} catch (Exception e) {
			menu.displayMessage("Unknown error occurred: " + e.getMessage());
		}
		
		// Display the lines to the user
		for (String line : lines) {
			menu.displayMessage( line );
		}
		
	}
	
}
