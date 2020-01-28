package com.techelevator.delivery;

public class SPU4DayGround implements DeliveryDriver {	
		
	@Override
	public String getName() {
		return "SPU (4-Day Ground)";
	}

	@Override
	public double calculateRate(int distance, double weightInPounds) {
		return (weightInPounds * 0.0050) * distance;
	}

}
