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

		System.out.print("Should the search be case sensitive? (Y or N) ");
		String sensitive = in.nextLine();

		int count = 1;

		try (Scanner fileScanner = new Scanner(file)) {

			while (fileScanner.hasNextLine()) {

				String line = fileScanner.nextLine();

				if (sensitive.equalsIgnoreCase("N")) {

					if (line.toLowerCase().contains(word.toLowerCase())) {
						System.out.println(count + ") " + line);
					}
				} else if (sensitive.equalsIgnoreCase("Y")) {

					if (line.contains(word)) {
						System.out.println(count + ") " + line);
					}
				}
				count++;
			}
		}
	}
}
