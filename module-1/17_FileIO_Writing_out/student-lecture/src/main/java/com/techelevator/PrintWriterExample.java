package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		
		//Writing to a file without buffering
		
		//1. file object with file path
		File ourFile = new File("test");
		
		//2. PrintWriter
		try (PrintWriter writer = new PrintWriter(ourFile)) {
			
			//3. Call the print method with text
			writer.println("This is some data in a file");
			
//			FOR HOMEWORK
//			for (int i = 1; i < 300; i++) {
//				writer.println(i);
//			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + ourFile.getAbsolutePath());
		}
		
		//Writing to a file with buffering
		
		//1. file object with file path
		File bufferedFile = new File("buffered");
		
		//2. create printwriter passing it the file
		try (PrintWriter printWriter = new PrintWriter(bufferedFile);
				
				//3. create bufferedwriter passing it printwriter
				BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
		
			//the write method does not add a new line by default
			bufferedWriter.write("our text with buffer\n"); //the \n starts a new line
			bufferedWriter.write("our second text with buffer");
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + bufferedFile.getAbsolutePath());

		} catch (IOException e1) {
			System.out.println("unknown IOException " + e1.getMessage());

		}
		
		
	}

}
