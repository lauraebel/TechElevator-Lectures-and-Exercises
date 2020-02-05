package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		
		/* 
		 * Writing to a File without Buffering
		 */
		
		// 1. File Object with the file path
		File ourFile = new File("test");
		
		// 2. Printer Writer 
		try ( PrintWriter writer = new PrintWriter(ourFile) ) {
			
			// 3. Call the print method with text
			writer.println("Something else");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found! " + ourFile.getAbsolutePath() );
		}
		
		
		/*
		 * Writing to a File with Buffering
		 */
		// 1. File Object with the file path
		File bufferedFile = new File("bufferedText");
		
		// 2. create a printWriter, passing it the File
		try ( PrintWriter printWriter = new PrintWriter(bufferedFile); 
				// 3. create a bufferedWriter, passing it the PrintWriter
				BufferedWriter bufferedWriter = new BufferedWriter( printWriter) ) {
			
			// The write() method does not add a new line by default
			bufferedWriter.write("Our text written with a buffer\n");
			bufferedWriter.write("Our text written with a buffer");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found! " + bufferedFile.getAbsolutePath() );
		} catch (IOException e1) {
			System.out.println("Unknown IOException: " + e1.getMessage());
		}

	}

}
