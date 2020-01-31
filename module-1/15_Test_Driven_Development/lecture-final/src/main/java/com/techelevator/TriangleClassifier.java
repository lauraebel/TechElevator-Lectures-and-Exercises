package com.techelevator;

public class TriangleClassifier {

	public String classify( int sideOne, int sideTwo, int sideThree ) {
		
		if (sideOne == sideTwo && sideOne == sideThree) {
			return "equilateral";
		}
		
		if (sideOne != sideTwo 
				&& sideOne != sideThree 
				&& sideTwo != sideThree) {
			return "scalene";
		}
		
		if (sideOne == sideTwo && sideOne != sideThree) {
			return "isosceles";
		}
		
		if (sideOne == sideThree && sideOne != sideTwo) {
			return "isosceles";
		}
		
		return null;
	}
	
	
}
