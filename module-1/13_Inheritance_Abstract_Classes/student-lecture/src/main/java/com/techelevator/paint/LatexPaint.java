package com.techelevator.paint;

public class LatexPaint extends Paint {

	private int costPerBucket = 20;
	
	@Override
	public String getName() {
		return "Latex Paint";
	}

	@Override
	public double calculateCost(int area) {
		return getCostOfPaintForArea(area, costPerBucket);
}

	
	
}
