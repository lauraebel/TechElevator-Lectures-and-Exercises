package com.techelevator.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

public class TollCalculator {

	public static void main(String[] args) {
		
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Tank());
		
		Vehicle carWithTrailer = new Car(true);
		Vehicle carWithoutTrailer = new Car(false);
		vehicles.add(carWithTrailer);
		vehicles.add(carWithoutTrailer);
		
		Vehicle truckWith4Axles =  new Truck(4);
		Vehicle truckWith6Axles = new Truck(6);
		Vehicle truckWith8Axles = new Truck(8);
		vehicles.add(truckWith4Axles);
		vehicles.add(truckWith6Axles);
		vehicles.add(truckWith8Axles);
		
		String heading1 = "Vehicle";
		String heading2 = "Distance Traveled";
		String heading3 = "Toll $";
					
		System.out.printf("%-30s    %-30s      %-3s%n", heading1, heading2, heading3);
		System.out.println("------------------------------------------------------------------------------");
		
		int milesTraveled = 0;
		double totalToll = 0;
		
		for(Vehicle vehicle : vehicles) {
			int randomDistance = (int) (Math.random() * ((240 - 10) + 1)) + 10;

			double toll = vehicle.calculateToll(randomDistance);
			
			System.out.printf("%-30s      %-30s      %-3.2f%n", vehicle.getName(), randomDistance, toll);
			
			milesTraveled += randomDistance;
			totalToll += toll;
					 
	}
		
		System.out.println();
		System.out.println("Total Miles Traveled: " + milesTraveled);
		System.out.println();
		System.out.printf("Total Tollbooth Revenue: %.2f", totalToll);

		
	}
}
