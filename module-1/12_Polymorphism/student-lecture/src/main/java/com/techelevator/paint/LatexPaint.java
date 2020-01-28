package com.techelevator.paint;

public class LatexPaint implements Paint {

	private int costPerBucket = 20;
	
	@Override
	public String getName() {
		return "Latex Paint";
	}

	@Override
	public double calculateCost(int area) {
		return (area/600) * costPerBucket;
	}
	
	

}
