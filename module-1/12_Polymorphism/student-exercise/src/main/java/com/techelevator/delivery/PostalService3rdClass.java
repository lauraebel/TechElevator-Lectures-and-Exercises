package com.techelevator.delivery;

public class PostalService3rdClass implements DeliveryDriver {

	double rate;
	
	@Override
	public double calculateRate(int distance, double weight) {
	if (weight >= 0 && weight <= 2) {
		rate = 0.0020 * distance;
		return rate;
	} else if (weight >= 3 && weight <= 8) {
		rate = 0.0022 * distance;
		return rate;
	} else if (weight >= 9 && weight <= 15) {
		rate = 0.0024 * distance;
		return rate;
	} else if (weight >= 16 && weight <= 48) {
		rate = 0.0150 * distance;
	} else if (weight >= 64 && weight <= 128) {
		rate = 0.0160 * distance;
		return rate;
	} else if (weight >= 144) {
		rate = 0.0170 * distance;
		return rate;
	}
	return rate;
	}

	
//	| 0 - 2      |   0.035   |   0.0035  |   0.0020  |
//	| 3 - 8      |   0.040   |   0.0040  |   0.0022  |
//	| 9 - 15     |   0.047   |   0.0047  |   0.0024  |
//	| 16 - 48    |   0.195   |   0.0195  |   0.0150  |
//	| 64 - 128   |   0.450   |   0.0450  |   0.0160  |
//	| 144+       |   0.500   |   0.0500  |   0.0170 

	@Override
	public String getName() {
		return "Postal Service - 3rd Class";
				}



	
}
