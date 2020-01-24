package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> listOfCards = new ArrayList<Card>();
	//have to import java.util list and arraylist for the above to work
	
	private static final String[] suits = {"c", "s", "d", "h"};
	private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
	
	public Deck() {
		for (String suit : suits) {
			for (String rank : ranks) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	public Card deal() {
		if(size() !=0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}
	
	//Delegate Method
	public int size() {
		return listOfCards.size();
	}
	
	
	@Override
	public String toString() {
		flip();
		String deckAsString = "Deck[listOfCards=" + listOfCards + "]";
		flip();
		return deckAsString;
		
	}
	private void flip() {
		for (Card card : listOfCards) {
			card.flip();
		}
	}
}
