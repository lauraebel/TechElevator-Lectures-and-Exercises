package com.techelevator.delivery;

public class SPU2DayGround implements DeliveryDriver {

	@Override
	public String getName() {
		return "SPU (2-Day Ground)";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		weight = weight/16;
		return (weight * 0.050) * distance;
	}

	
	
}
