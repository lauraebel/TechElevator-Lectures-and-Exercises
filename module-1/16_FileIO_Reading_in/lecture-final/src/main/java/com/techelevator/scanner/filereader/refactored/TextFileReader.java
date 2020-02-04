package com.techelevator.scanner.filereader.refactored;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements FileReader {

	private File file;
	
	public TextFileReader(File file) {
		this.file = file;
	}
	
	
	@Override
	public List<String> read(int lineCount) throws FileNotFoundException {
		List<String> lines = new ArrayList<String>();
		
		try (Scanner fileScanner = new Scanner(this.file)) {
			while ( fileScanner.hasNextLine() && lineCount > 0) {
				String line = fileScanner.nextLine();
				lines.add( line );
				lineCount--;
			}
		}
		
		return lines;
	}

}
