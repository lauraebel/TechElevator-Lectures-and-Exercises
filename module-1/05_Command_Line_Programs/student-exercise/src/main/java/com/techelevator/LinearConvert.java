package com.techelevator;
import java.util.Scanner;

// m = f * 0.3048
// f = m * 3.2808399
// Please enter the length: 58
// Is the measurement in (m)eter, or (f)eet? f
// 58f is 17m

public class LinearConvert {

	public static void main(String[] args) {
		
		double meterConversion = 0.3048;
		double feetConversion = 3.2808399;

		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a length: " );
		String userLength = in.nextLine();
		
		double yourChosenLength = Double.parseDouble(userLength);
		
		System.out.print("Is it in meters (m) or feet (f)? ");
		String userMOrF = in.nextLine();
		
		if (userMOrF.equalsIgnoreCase("F")) {
		
		double convertedToMeters = yourChosenLength * meterConversion;
		System.out.println("You chose " + yourChosenLength + " feet and this converts to " + convertedToMeters + " meters");

		} else if  (userMOrF.equalsIgnoreCase("M")) {
			
		double convertedToFeet = yourChosenLength * feetConversion;
		System.out.println("You chose " + yourChosenLength + " meters and this converts to " + convertedToFeet + " feet");

		}
		else { 
				System.out.println("Error, please enter (m) or (f)");
	}
}
}

