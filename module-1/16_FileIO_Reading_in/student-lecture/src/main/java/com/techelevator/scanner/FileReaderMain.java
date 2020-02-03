package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Path to File>");
		String filename = in.nextLine();
		
		File file = new File(filename);
		
		System.out.print("number of lines");
		int lineCount = in.nextInt();
		in.hasNextLine();
		
		try (Scanner filescanner = new Scanner (file)) {
			
			while(filescanner.hasNextLine()) {
				String line = filescanner.nextLine();
				System.out.println(line);
				lineCount--;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File " + file.getAbsolutePath() + " not found");
		}
		
	}

}
