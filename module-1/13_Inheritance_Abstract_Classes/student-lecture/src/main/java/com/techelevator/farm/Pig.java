package com.techelevator.farm;

public final class Pig extends FarmAnimal {

	public Pig() {
		super("Pig", "Oink!", 200);
	}

	@Override
	public String eat() {
		return "Pig eating";
	}
	
//	@Override
//	public String getSound() {
//		return "Oink!";
//	}
	// ^ Can't override getSound because it is final in FarmAnimal 

}
