package com.techelevator.delivery;

public class FexEd implements DeliveryDriver {

	double rate;
	
	@Override
	public String getName() {
		return "FexEd";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		if (distance <= 500 && weight <= 48) {
			rate = 20;
		}
		else if (distance > 500 && weight <= 48) {
			rate = 20 + 5;
		} 
		else if (distance > 500 && weight > 48) {
			rate = 20 + 8;
		} else if (distance <= 500 && weight > 48) {
			rate = 20 + 3;
		}
		return rate;
	}

}
