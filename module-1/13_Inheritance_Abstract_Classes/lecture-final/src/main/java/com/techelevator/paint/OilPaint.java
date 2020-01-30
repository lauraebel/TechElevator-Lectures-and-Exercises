package com.techelevator.paint;

public class OilPaint extends Paint {

	private boolean interior;
	
	public OilPaint( boolean interior ) {
		this.interior = interior;
	}
	
	
	@Override
	public String getName() {
		if (interior) {
			return "Interior Oil Paint";
		}
		return "External Oil Paint";
	}

	@Override
	public double calculateCost(int area) {
		if (interior) {
			return getCostOfPaintForArea(area, 30);
		}
		return getCostOfPaintForArea(area, 50);
	}
	
	

}
