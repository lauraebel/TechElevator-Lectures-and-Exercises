package com.techelevator.delivery;

public class SPU4DayGround implements DeliveryDriver {	
		
	@Override
	public String getName() {
		return "SPU (4-Day Ground)";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		weight = weight/16;
		return (weight * 0.0050) * distance;
	}

}
