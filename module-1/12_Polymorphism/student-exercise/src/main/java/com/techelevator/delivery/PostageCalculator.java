package com.techelevator.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.vehicle.Tank;
import com.techelevator.vehicle.Vehicle;

public class PostageCalculator {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the weight of the package: ");
		String userWeight = in.nextLine();
		double weight = Double.parseDouble(userWeight);

		System.out.print("(P)ounds or (O)unces? ");
		String userPOrO = in.nextLine();

		if (userPOrO.equalsIgnoreCase("P")) {
			weight *= 16;
			} else if (userPOrO.equalsIgnoreCase ("O")) {
				weight = weight;
			}
		
		System.out.print("Amount of miles the package will be traveling: ");
		String userMiles = in.nextLine();
		int distance = Integer.parseInt(userMiles);

		List<DeliveryDriver> deliveryMethod = new ArrayList<DeliveryDriver>();

		DeliveryDriver postalFirst = new PostalService1stClass();
		DeliveryDriver postalSecond = new PostalService2ndClass();
		DeliveryDriver postalThird = new PostalService3rdClass();
		DeliveryDriver fexEd = new FexEd();
		DeliveryDriver spuFour = new SPU4DayGround();
		DeliveryDriver spuTwo = new SPU2DayGround();
		DeliveryDriver spuNext = new SPUNextDay();
		
		deliveryMethod.add(postalFirst);
		deliveryMethod.add(postalSecond);
		deliveryMethod.add(postalThird);
		deliveryMethod.add(fexEd);
		deliveryMethod.add(spuFour);
		deliveryMethod.add(spuTwo);
		deliveryMethod.add(spuNext);
		
		System.out.println();
		
		String heading1 = "Delivery Method";
		String heading2 = "$ cost";
		
		System.out.printf("%-37s      %-3s%n", heading1, heading2);
		System.out.println("=======================================================");
		
		String dolla = "$";
		int totalDistance = 0;
		double totalCost = 0;
		
		for(DeliveryDriver delivery : deliveryMethod) {
			double cost = delivery.calculateRate(distance, weight);
						
			System.out.printf("%-40s   %1s   %-3.2f%n", delivery.getName(), dolla, cost);
			
		}		
		
		
	}

}
