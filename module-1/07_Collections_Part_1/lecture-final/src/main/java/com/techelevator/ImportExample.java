package com.techelevator;


public class ImportExample {
	
	public static void main(String[] args) {
		
		java.util.Scanner in = new java.util.Scanner(java.lang.System.in);
		
		java.lang.System.out.println("Pick a whole number?");
		
		java.lang.String userChoice = in.nextLine();
		int number = java.lang.Integer.parseInt(userChoice);
		
		com.techelevator.data.NumberCruncher numberCruncher = new com.techelevator.data.NumberCruncher();
		java.lang.Integer newNumber = numberCruncher.multiplyNumberBy10(number);
		
		java.lang.System.out.println("Your number multiplied by 10 is " + newNumber);

	}

}
