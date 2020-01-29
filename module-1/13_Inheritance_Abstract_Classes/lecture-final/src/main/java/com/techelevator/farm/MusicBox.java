package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return "Duh Duh Doo";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Music Box";
	}

}
