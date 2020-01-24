package com.techelevator;

public class Card {


	public Card(String suit, String rank) {

	}
	
	public boolean flip() {
		return false;
	}
	

	
	public String getSuit() {
		return "";
	}
	public String getRank() {
		return "";
	}
	public boolean isFaceUp() {
		return true;
	}

	
	@Override
	public String toString() {
			return "##";
	
	}
	
}
