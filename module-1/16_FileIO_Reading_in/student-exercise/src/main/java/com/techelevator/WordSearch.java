package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Path to file -> ");
		String filename = in.nextLine();
		
		File file = new File(filename);
		
		System.out.print("What word are you searching for? ");
		String word = in.nextLine();
		
		try(Scanner fileScanner = new Scanner(file)) {
			
				
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if(line.contains(word)) {
				System.out.println(word + line);

				}
				
			}
		}

}
}
