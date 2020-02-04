package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		
		File fizzFile = new File("FizzBuzz.txt");
		
		try (PrintWriter printWriter = new PrintWriter(fizzFile);
				BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
				for (int num = 1; num <= 300; num++) {
					bufferedWriter.write(getResult (num) + System.getProperty("line.separator"));
				}
			}
		System.out.println("FizzBuzz.txt has been created");
	}
	
		private static String getResult(int num) {
			
			String result = String.valueOf(num);
			
			if (num % 3 == 0 && num % 5 == 0) {
				result = "FizzBuzz";
			} else if ((num % 5 == 0) || (String.valueOf(num).contains("5") && !String.valueOf(num).contains("3"))) {
				result = "Buzz";
			} else if ((num % 3 == 0) || (String.valueOf(num).contains("3") && !String.valueOf(num).contains("5"))) {
				result = "Fizz";
			}
			return result;
		}
		
	}

