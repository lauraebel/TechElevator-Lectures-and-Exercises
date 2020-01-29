package com.techelevator.farm;

public final class Pig extends FarmAnimal {

	public Pig() {
		super("Pig", "Oink!", 200);
	}

	@Override
	public String eat() {
		return "Pig eating";
	}
	
	// Can't override getSound() because it is final
//	@Override
//	public String getSound() {
//		return "Oink!";
//	}

}
