package com.techelevator.delivery;

public class SPU2DayGround implements DeliveryDriver {

	@Override
	public String getName() {
		return "SPU (2-Day Ground)";
	}

	@Override
	public double calculateRate(int distance, double weightInPounds) {
		return (weightInPounds * 0.050) * distance;
	}

	
	
}
