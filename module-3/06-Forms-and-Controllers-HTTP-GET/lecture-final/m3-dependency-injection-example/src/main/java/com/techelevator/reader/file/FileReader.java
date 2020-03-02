package com.techelevator.reader.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	private File file;
	
	public FileReader(File file) {
		this.file = file;
	}
	
	protected List<String> readLines() throws FileNotFoundException {
		
		List<String> lines = new ArrayList<String>();
		
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
		}
		
		
		return lines;
	}
}
