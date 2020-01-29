package com.techelevator.delivery;

public class SPUNextDay implements DeliveryDriver {

	@Override
	public String getName() {
		return "SPU (Next Day)";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		weight = weight/16;
		return (weight * 0.075) * distance;
	}
	

}
