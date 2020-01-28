package com.techelevator.vehicle;

public class Truck implements Vehicle {

	int numberOfAxles;
	
	Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}

	@Override
	public String getName() {
		if (numberOfAxles == 4) {
			return "Truck With 4 Axles";
		} else if (numberOfAxles == 6) {
			return "Truck With 6 Axles";
		} else if (numberOfAxles == 8) {
			return "Truck With 8 Axles";
		}
		return null;
	}

	@Override
	public double calculateToll(int distance) {
		if (numberOfAxles == 4) {
			double toll = distance * 0.040;
			return toll;
		} else if (numberOfAxles == 6) {
			double toll = distance * 0.045;
			return toll;
		} else if (numberOfAxles == 8) {
			double toll = distance * 0.048;
			return toll;
		}
		return 0;
	}

	public int getNumberOfAxles() {
		return numberOfAxles;

	}
}
