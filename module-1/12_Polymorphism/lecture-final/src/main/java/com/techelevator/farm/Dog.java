package com.techelevator.farm;

public class Dog implements Singable {

	public Dog() {
		
	}

	@Override
	public String getSound() {
		return "Woof!";
	}

	@Override
	public String getName() {
		return "Dog";
	}

}
