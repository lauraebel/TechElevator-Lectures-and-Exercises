package com.techelevator;

import java.util.Scanner;


// Tf = Tc * 1.8 + 32 -> Cel to Far
// Tc = (Tf - 32) / 1.8 -> Far to Cel

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please Enter a Temperature: ");
		String userTemp = in.nextLine();
		
		double userChosenTemp = Double.parseDouble(userTemp);
		
		System.out.print("Is this in Farenheit (f) or Celcius (c)? ");
		String userFOrC = in.nextLine();
		
		if (userFOrC.equalsIgnoreCase("F")) {
		
			double celToFar = (userChosenTemp - 32) / 1.8;
			System.out.print("You chose " + userChosenTemp + " Farenheit. This converts to " + celToFar + " Celcius");
		}
		else if (userFOrC.equalsIgnoreCase("C")) {
			
			double farToCel = userChosenTemp * 1.8 + 32;
			System.out.print("You chose " + userChosenTemp + " Celcius. This converts to " + farToCel + " Farenheit");
		}
		else {
			System.out.println("Error. Please use (f) for Farenheit or (c) for Celcius.");
		}
	}

}

