package com.techelevator;

import java.util.Scanner;

public class EarthToSunWeightConverter {

	/*
	 * Command line programs usually follow this work flow:   Take Data, Calculate Data, Give Results
	 * 
	 * How can we do each of these steps?
	 */
	public static void main(String[] args) {
		
		int sunGravity = 28;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the weight on Earth: ");
		String userInput = in.nextLine();
		
		
		
		int earthWeight = Integer.parseInt(userInput);
		
		int weightOnSun = earthWeight * sunGravity;
		
		System.out.printf("%-15s    %-15s%n", "Earth (lbs)", "Sun (lbs)");
		System.out.println("----------------------------------");
		System.out.printf("%-15s    %-15s%n", earthWeight, weightOnSun);

	}

}
