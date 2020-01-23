package com.techelevator;

public class RectangleDemo {

	public static void main(String[] args) {

		Rectangle rectOne = new Rectangle();
		
		rectOne.setHeight(-10);
		rectOne.setWidth(12);
		
		System.out.println(rectOne.getHeight()); //will print as a positive due to the setter changing to absolute value
		System.out.println(rectOne.getWidth());
		System.out.println(rectOne.getArea());
		
		Rectangle rectTwo = new Rectangle();
		rectTwo.setHeight(22);
		rectTwo.setWidth(8);
		
		System.out.println(rectOne.isLargerThan(rectTwo));
		
		System.out.println(rectTwo.isLargerThan(5, 7));
		
		Rectangle rectThree = new Rectangle(-7, 3); //if we are overloaded, we need to have the constructor
		//for all variables to be valid
		
		System.out.println(rectThree.getArea());
		
		Rectangle rectFour = new Rectangle(12, 10);
		
		if (rectOne.equals(rectFour)) {
			System.out.println("They are equal");
		}
		System.out.println(rectOne);
	}
	

}
