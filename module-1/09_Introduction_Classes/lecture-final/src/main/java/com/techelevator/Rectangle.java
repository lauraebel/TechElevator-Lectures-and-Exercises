package com.techelevator;

public class Rectangle {

	// Member variables
	private int height = 0;
	private int width = 0;
	
	
	// no-argument constructor
	// If need ONLY this constructor, then it is defaulted without
	// being explicit in the code
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.height = getValidDimension(height);
		this.width = getValidDimension(width);
	}
	
	// Properties - stored values in member variables
	// Getter for member variable height
	public int getHeight() {
		return this.height;
	}
	
	// Set for member variable height
	public void setHeight(int height) {
		this.height = getValidDimension(height);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = getValidDimension(width);
	}
	
	// Derived Property - calculate value each time
	//                    using member variables.
	//                    DOES NOT STORE VALUE
	public int getArea() {
		return this.height * this.width;
	}
	
	// Member methods/functions provide behavior
	public boolean isLargerThan( Rectangle other ) {
		return this.getArea() > other.getArea();
	}
	
	public boolean isLargerThan( int width, int height) {
		return this.getArea() > ( width * height );
	}
	
	private int getValidDimension(int i) {
		if (i < 0) {
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
		return this.width + "x" + this.height + " - " + this.getArea() + " sqft";
	}
	
}
