package com.techelevator.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.vehicle.Tank;

public class PostageCalculator {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the weight of the package: ");
		String userWeight = in.nextLine();
		double yourChosenWeight = Double.parseDouble(userWeight);

		System.out.print("(P)ounds or (O)unces? ");
		String userPOrO = in.nextLine();
		double yourChosenMeasurement = Double.parseDouble(userWeight);

		if (userPOrO.equalsIgnoreCase("P")) {
			double inOunces = yourChosenMeasurement * 16;
		} else if (userPOrO.equalsIgnoreCase("O")) {
			return;
		}
		
		System.out.print("Amount of miles the package will be traveling: ");
		String userMiles = in.nextLine();
		double yourChosenMiles = Double.parseDouble(userMiles);

		List<DeliveryDriver> deliveryMethod = new ArrayList<DeliveryDriver>();


		
	}

}
