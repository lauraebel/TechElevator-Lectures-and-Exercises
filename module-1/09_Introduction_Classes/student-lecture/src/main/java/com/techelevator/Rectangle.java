package com.techelevator;

public class Rectangle {
	
	//member variables
	private int height = 0;
	private int width = 0;
	
	//no argument constructor
	//if need only this constructor, then it is defaulted without being explicit in the code
	//this code does not need typed- it just works on its own
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.height = getValidDimension(height);
		this.width = getValidDimension(width);
	}
	
	//properties-store values in member variables
	//getter for member variable height
	public int getHeight() {
		return this.height;
	}
	//setter for member variable height
	public void setHeight(int height) {
		this.height = Math.abs(height); //this sets absolute value so no one can change to negative values
	}
	
	//getter for member variable width
	public int getWidth() {
		return this.width;
	}
	//setter for member variable width
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	//derived property-calculate values using member variables but DOES NOT store values
	public int getArea() {
		return this.height * this.width;
	}
	//member function/method provides behavior
	public boolean isLargerThan(Rectangle other) {
		return this.getArea() > other.getArea(); //if this rect is larger than the other, return true
	}
	
	public boolean isLargerThan(int width, int height) {
		return this.getArea() > (width * height);
	}
	
	private int getValidDimension(int i) {
		if (i<0) {
			return Math.abs(i);
		}
		return i;
		}
	@Override
	public boolean equals(Object obj) {
		Rectangle other = (Rectangle) obj;
		
		return this.height == other.getHeight() && this.width == other.getWidth();
	}
	
	@Override
	public String toString() {
		return this.width + "x" + this.height + " - " + this.getArea() + "sqft";
	}
}
