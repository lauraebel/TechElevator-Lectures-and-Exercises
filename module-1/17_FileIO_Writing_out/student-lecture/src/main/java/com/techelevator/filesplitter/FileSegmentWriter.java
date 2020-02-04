package com.techelevator.filesplitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileSegmentWriter implements SegmentWriter {
	
	private String filename;
	
	public FileSegmentWriter(String filename) {
		this.filename = filename;
	}

	@Override
	public void write(List<String> lines, int segment) throws SegmentWriterException {
		
		File outputFile = new File(filename + "-" + segment);
		
		try(PrintWriter printWriter = new PrintWriter(outputFile);
				BufferedWriter buffered = new BufferedWriter(printWriter)) {
			
			for(String line : lines) {
				buffered.write(line + System.getProperty("line.separator"));
			}
			
		} catch (IOException e) {
			throw new SegmentWriterException(e);
		}
		
		
	}
	

}
