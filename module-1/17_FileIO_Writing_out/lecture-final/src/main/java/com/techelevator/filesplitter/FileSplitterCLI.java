package com.techelevator.filesplitter;

import java.io.File;
import java.io.FileNotFoundException;

import com.techelevator.filesplitter.view.Menu;

public class FileSplitterCLI {

	private Menu menu = new Menu();
	
	public void run() {
		
		// Get the file from the user
		File file = getFile();
		
		// Get a line count from the user for the split
		int lineCount = menu.getLineCountFromUser();
		
		// Split the file into segments
		FileSplitter splitter = new FileSplitter();
		
		try {
			splitter.split(file, lineCount);
		} catch (FileNotFoundException e) {
			menu.displayMessage("File not found: " + e.getMessage());
		} catch (SegmentWriterException e) {
			menu.displayMessage("Unable to write file segment: " + e.getMessage());
		}
		
		// Inform the user it is complete
		menu.displayMessage("Split complete!");
	}
	
	private File getFile() {
		File file = null;
		
		while (file == null) {
			String filename = menu.getPathFromUser();
			file = new File(filename);
			
			if ( !file.exists() || !file.isFile() ) {
				menu.displayMessage(filename + " is not valid.  Please try again!");
				file = null;
			}
		}
		
		
		return file;
	}
	
	
	public static void main(String[] args) {
		FileSplitterCLI cli = new FileSplitterCLI();
		cli.run();
	}

}
