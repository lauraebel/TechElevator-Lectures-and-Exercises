package com.techelevator.cards;

public class Card {
	
	//properties
	private String suit;
	private String rank;
	private boolean faceUp = false;
	
	//creating the constructor
	public Card(String suit, String rank) {
		//'this' is required because there are 2 different instances of suit above so it is ambiguous
		this.suit = suit;
		this.rank = rank;
	}
	
	//behavior -> Method
	public boolean flip() {
		//'this' not needed because only one instance of faceUp above
		faceUp = !faceUp;
		return faceUp;
	}
	
	
	//getters
	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	
	@Override 
	public String toString() {
		if(faceUp) {
			return rank + suit;
		} else {
			return "##";
		}
	}

}
