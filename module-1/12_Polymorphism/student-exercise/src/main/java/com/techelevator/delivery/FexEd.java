package com.techelevator.delivery;

public class FexEd implements DeliveryDriver {

	double rate = 20.00;
	
	public double longDistanceRate(double distanceInMiles) {
		if (distanceInMiles <= 500) {
			rate = 20.00;
		} else if (distanceInMiles > 500) {
			rate += 5;
		}
		return rate;
	}
	
	public double oversizeRate(double weightInOunces) {
		if (weightInOunces <= 48) {
			rate = 20.00;
		} else if (weightInOunces > 48) {
			rate += 3;
		}
		return rate;
	}
	
	@Override
	public String getName() {
		return "FexEd";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		return rate;
	}

}
