package com.techelevator;

/**
 * Classifies Triangles
 * 
 * @author lauraebel
 *
 */

public class TriangleClassifier {
	
	private final static String TYPE_INVALID = "invalid";
	private final static String TYPE_EQUILATERAL = "equilateral";
	private final static String TYPE_ISOSCELES = "isosceles";
	private final static String TYPE_SCALENE = "scalene";
	
	/**
	 * Classifies a triangle by Equilateral, Scalene, Isosceles, or Invalid.
	 * 
	 * @param sideOne - length of first side of triangle
	 * @param sideTwo - length of second side of triangle
	 * @param sideThree -length of third side of triangle
	 * @return [String] - returns triangle type
	 */
	
	public String classify(int sideOne, int sideTwo, int sideThree) {
		if(!isValidTriangle(sideOne, sideTwo, sideThree)) {
			return TYPE_INVALID;
		}
		
		if(isEquilateralTriangle(sideOne, sideTwo, sideThree)) {
			return TYPE_EQUILATERAL;
		}
		if(isScaleneTriangle(sideOne, sideTwo, sideThree)) {
			return TYPE_SCALENE;
		}
		if(isIsoscelesTriangle(sideOne, sideTwo, sideThree )) {
			return TYPE_ISOSCELES;
		}
		return TYPE_INVALID;
	}
	
	private boolean isValidTriangle(int sideOne, int sideTwo, int sideThree) {
		if((sideOne + sideTwo <= sideThree) || (sideTwo + sideThree <= sideOne) || (sideOne + sideThree <= sideTwo) ){
			return false;
		}
		return true;
	}
	
	private boolean isEquilateralTriangle(int sideOne, int sideTwo, int sideThree) {
		return (sideOne == sideTwo && sideOne == sideThree);
	}
	
	private boolean isScaleneTriangle(int sideOne, int sideTwo, int sideThree) {
		return (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree);
	}
	private boolean isIsoscelesTriangle(int sideOne, int sideTwo, int sideThree ) {
		return ((sideOne == sideTwo && sideOne != sideThree) || (sideOne == sideThree && sideOne != sideTwo) || (sideTwo == sideThree && sideTwo != sideOne));
	}
	

}
