package com.techelevator;

public class TriangleClassifier {

	private final static String TYPE_INVALID = "invalid";
	private final static String TYPE_EQUILATERAL = "equilateral";
	private final static String TYPE_SCALENE = "scalene";
	private final static String TYPE_ISOSCELES = "isosceles";
	
	public String classify( int sideOne, int sideTwo, int sideThree ) {
		

		if ( !isValidTriangle(sideOne, sideTwo, sideThree) ) {
			return TYPE_INVALID;
		}
		
		if ( isEquilateralTriangle(sideOne, sideTwo, sideThree )) {
			return TYPE_EQUILATERAL;
		}
		
		if ( isSclaneTriangle(sideOne, sideTwo, sideThree) ) {
			return TYPE_SCALENE;
		}
		
		if ( isIsoscelesTriangle(sideOne, sideTwo, sideThree) ) {
			return TYPE_ISOSCELES;
		}
		
		return TYPE_INVALID;
	}
	
	
	
	private boolean isIsoscelesTriangle(int sideOne, int sideTwo, int sideThree) {
		if ( (sideOne == sideTwo && sideOne != sideThree) ||
				(sideOne == sideThree && sideOne != sideTwo) ||
				( sideTwo == sideThree && sideTwo != sideOne)) {
			return true;
		}
		return false;
	}
	
	private boolean isValidTriangle(int sideOne, int sideTwo, int sideThree) {
		if ( (sideOne + sideTwo <= sideThree) ||
				(sideTwo + sideThree <= sideOne) ||
				(sideOne + sideThree <= sideTwo) ) {
			return false;
		}
		return true;
	}
	
	private boolean isEquilateralTriangle(int sideOne, int sideTwo, int sideThree) {
		return ( sideOne == sideTwo && sideOne == sideThree );
	}
	
	private boolean isSclaneTriangle(int sideOne, int sideTwo, int sideThree) {
		if (sideOne != sideTwo 
				&& sideOne != sideThree 
				&& sideTwo != sideThree) {
			return true;
		}
		return false;
	}
	
	
}
