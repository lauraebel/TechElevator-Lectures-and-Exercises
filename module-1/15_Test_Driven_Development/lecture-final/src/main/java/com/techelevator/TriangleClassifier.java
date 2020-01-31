package com.techelevator;

public class TriangleClassifier {

	public String classify( int sideOne, int sideTwo, int sideThree ) {
		
		
		if (sideOne + sideTwo <= sideThree) {
			return "invalid";
		}
		
		if (sideOne == sideTwo && sideOne == sideThree) {
			return "equilateral";
		}
		
		if (sideOne != sideTwo 
				&& sideOne != sideThree 
				&& sideTwo != sideThree) {
			return "scalene";
		}
		
		if ( (sideOne == sideTwo && sideOne != sideThree) ||
				(sideOne == sideThree && sideOne != sideTwo) ||
				( sideTwo == sideThree && sideTwo != sideOne)) {
			return "isosceles";
		}
		
		
		return null;
	}
	
	
}
