package com.techelevator.filesplitter;

import java.io.File;
import java.io.FileNotFoundException;

import com.techelevator.filesplitter.view.Menu;

public class FileSplitterCLI {
	
	private Menu menu = new Menu();
	
	public void run() { //all the work will be done here because the main is static
		
		//get the file from the user
		File file = getFile();
		
		//get a line count from the user for the split
		int lineCount = menu.getLineCountFromUser();
		
		//split the file into segments
		FileSplitter splitter = new FileSplitter();
		try {
			splitter.split(file, lineCount);
		} catch (FileNotFoundException e) {
			menu.displayMessage("File Not found: " + e.getMessage());
				e.printStackTrace();
		} catch (SegmentWriterException e) {
			menu.displayMessage("Unable to write file segment: " + e.getMessage());
		}
		
		//inform the user it is complete
		menu.displayMessage("Split Complete");
	}
	
	private File getFile() {
		File file = null;

		while (file == null) {

			String filename = menu.getPathFromUser();
			file = new File(filename);

			if (!file.exists() || !file.isFile()) {
				menu.displayMessage(filename + " is not valid. Try again.");
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
