package com.techelevator;

public class ColorWriterExample {
	
	private final static String FILE_NAME = "Colors.txt";
	private final static int UPPER_LIMIT = 200;
	
	public static void main(String[] args)  {
		
		for (int i = 1 ; i <= UPPER_LIMIT ; i++) {
			System.out.println(getOutput(i));
		}
		
		System.out.println("DONE!");
	}
	
	
	private static String getOutput(int i) {
		
		String output = String.valueOf(i);
		
		if (i % 5 == 0) {
			output = "RED";
		} else if (i % 7 == 0) {
			output = "BLUE";
		} else if (i % 9 == 0) {
			output = "GREEN";
		}
		
		return output;
	}
	
}
