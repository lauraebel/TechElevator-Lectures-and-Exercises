package com.techelevator.filesplitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

	
	public void split(File inputFile, int lineCount) throws FileNotFoundException, SegmentWriterException {
		
		// Split the file into parts
		SegmentWriter writer = new FileSegmentWriter(inputFile.getAbsolutePath());
		
		try ( Scanner fileScanner = new Scanner(inputFile) ) {
			
			int segment = 0;
			
			while (fileScanner.hasNextLine() ) {
			
				List<String> lines = new ArrayList<String>();
				
				int count = lineCount;
				while ( count > 0 && fileScanner.hasNextLine()) {
					lines.add( fileScanner.nextLine() );
					count--;
				}
				
				// Write the parts to new files
				segment++;
				writer.write(lines, segment);
				//lines = new ArrayList<String>();
				
			}
			
		}
		
	}
}
