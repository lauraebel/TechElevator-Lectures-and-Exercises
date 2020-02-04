package com.techelevator.filesplitter;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSplitter {

	public void split(File inputFile, int lineCount) throws FileNotFoundException, SegmentWriterException {

		// split the file into parts
		SegmentWriter writer = new FileSegmentWriter(inputFile.getAbsolutePath());
		
		try (Scanner fileScanner = new Scanner(inputFile)) {
			
			int segment = 0;
			
			while (fileScanner.hasNextLine()) { // main loop

				List<String> lines = new ArrayList<String>();

				int count = lineCount;
				while (count > 0 && fileScanner.hasNextLine()) { // subloop
					lines.add(fileScanner.nextLine());
					count--;
				}
				
				//write parts to new files
				segment++;
				
				//writer
				writer.write(lines, segment);
			}
		}

	}

}
