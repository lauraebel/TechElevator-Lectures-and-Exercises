package com.techelevator;

public class TriangleClassifier {

	public String classify( int sideOne, int sideTwo, int sideThree ) {
		
		
		
		if ( !isValidTriangle(sideOne, sideTwo, sideThree) ) {
			return "invalid";
		}
		
		if ( isEquilateralTriangle(sideOne, sideTwo, sideThree )) {
			return "equilateral";
		}
		
		if ( isSclaneTriangle(sideOne, sideTwo, sideThree) ) {
			return "scalene";
		}
		
		if ( isIsoscelesTriangle(sideOne, sideTwo, sideThree) ) {
			return "isosceles";
		}
		
		
		return null;
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
