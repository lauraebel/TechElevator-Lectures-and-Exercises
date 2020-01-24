package com.techelevator.cardExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.cards.Card;
import com.techelevator.cards.Deck;



public class TwentyOneCardGame {

	private static Scanner in = new Scanner(System.in);
	
	public void play() {
		
		List<Card> hand = new ArrayList<Card>();
		
		Deck deck = new Deck();
		deck.shuffle();
		
		Card firstCard = deck.deal();
		firstCard.flip();
		hand.add( firstCard );
		hand.add( deck.deal() );
		
		while (true) {
			
			showHand(hand);
			
			System.out.print("(H)it or (S)tand? >>>");
			
			String userChoice = in.nextLine();
			
			if (userChoice.equalsIgnoreCase("H")) {
				
				Card nextCard = deck.deal();
				nextCard.flip();
				hand.add( nextCard );
			} else if (userChoice.equalsIgnoreCase("S")) {
				break;
			} else {
				System.out.println("Invalid choice!");
			}
			
		}
		
		// We know the face down card is always the second, so flip it
		hand.get(1).flip();
		showHand(hand);
		
		int handTotal = totalHand(hand);
			
		System.out.println("Total = " + handTotal);
		
		if (handTotal <= 21) {
			System.out.println("You Win!");
		} else {
			System.out.println("Sorry you busted!");
		}
	}
	
	private void showHand(List<Card> hand) {
		for (Card card : hand) {
			System.out.print(card + " ");
		}
		System.out.println();
	}
	
	private int totalHand(List<Card> hand) {
		int total = 0;
		int acesFound = 0;
		for (Card card : hand) {
			int value = getCardValue(card);
			if (value == 11) {
				acesFound++;
			}
			total += value;
		}
		
		// If the ace value of 11 would exceed 21, count it as 1
		for (int i = 0; i < acesFound; i++) {
			if (total > 21) {
				total -= 10;
			}
		}
			
		return total;
	}
	
	private int getCardValue(Card card) {
		
		if (card.getRank().equals("A")) {
			return 11;
		}
		
		if (card.getRank().matches("[0-9]+")) {
			return Integer.parseInt(card.getRank());
		}
		
		return 10;
	}
	
	public static void main(String[] args) {
		TwentyOneCardGame game = new TwentyOneCardGame();
		game.play();
	}
	
	

}
