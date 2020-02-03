package com.techelevator.scanner.filereader.refactored;

import java.io.File;
import java.util.Scanner;


public class Menu {
	
	private Scanner in = new Scanner (System.in);
	
	public File getFileFromUser() {
		System.out.println("Path to file>");
		String filename = in.nextLine();
		File file = new File(filename);
		return file;
	}
	
	public int getLineCountFromUser() {
		System.out.print("Number of lines>");
		int lineCount = in.nextInt();
		in.hasNextLine();
		return lineCount;
	}

}
