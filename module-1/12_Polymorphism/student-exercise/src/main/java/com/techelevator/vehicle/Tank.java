package com.techelevator.vehicle;

public class Tank implements Vehicle {

	@Override
	public String getName() {
		return "Tank";
	}

	@Override
	public double calculateToll(int distance) {
		return 0;
	}
	

}
