package com.techelevator.delivery;

public class PostalService2ndClass implements DeliveryDriver {
	
	double perMile;
	
	PostalService2ndClass(double perMile) {
		this.perMile = perMile;
	}
	
	public double perMile(double weightInOunces) {
	if (weightInOunces >= 0 && weightInOunces <= 2) {
		perMile = 0.0035;
	} else if (weightInOunces >= 3 && weightInOunces <= 8) {
		perMile = 0.0040;
	} else if (weightInOunces >= 9 && weightInOunces <= 15) {
		perMile = 0.0047;
	} else if (weightInOunces >= 16 && weightInOunces <= 48) {
		perMile = 0.0195;
	} else if (weightInOunces >= 64 && weightInOunces <= 128) {
		perMile = 0.0450;
	} else if (weightInOunces >= 144) {
		perMile = 0.0500;
	}
	return perMile;

}
//	| 0 - 2      |   0.035   |   0.0035  |   0.0020  |
//	| 3 - 8      |   0.040   |   0.0040  |   0.0022  |
//	| 9 - 15     |   0.047   |   0.0047  |   0.0024  |
//	| 16 - 48    |   0.195   |   0.0195  |   0.0150  |
//	| 64 - 128   |   0.450   |   0.0450  |   0.0160  |
//	| 144+       |   0.500   |   0.0500  |   0.0170 


	@Override
	public String getName() {
		return "Postal Service - 2nd Class";
	}

	@Override
	public double calculateRate(int distance, double weight) {
		int rate = (int) (perMile * distance);
		return rate;
	}
}
