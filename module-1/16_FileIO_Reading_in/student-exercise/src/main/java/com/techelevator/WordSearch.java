package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Path to file -> ");
		String filename = in.nextLine();
		

//		System.out.print("number of lines >>>");
//		int lineCount = in.nextInt();
//		in.nextLine();
//		
		
		File file = new File(filename);
		
		System.out.print("What word are you searching for? ");
		String word = in.nextLine();
		
		try(Scanner fileScanner = new Scanner(filename)) {
			
			String line = fileScanner.nextLine();
				
			while(fileScanner.hasNextLine()) {
				if(line.contains(word)) {
				System.out.println(word + line);

				}

				
			}
		}

//				} catch ( FileNotFoundException e) {
//					System.out.println("File " + file.getAbsolutePath() + " not found");


}
}
