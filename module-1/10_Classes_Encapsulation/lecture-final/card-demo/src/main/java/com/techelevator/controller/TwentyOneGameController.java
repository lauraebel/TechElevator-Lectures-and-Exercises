package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.Card;
import com.techelevator.Deck;

@Controller
@SessionAttributes({"hand", "deck"})
public class TwentyOneGameController {

	@RequestMapping(path="/game", method=RequestMethod.GET)
	public String showTable(ModelMap map) {
		
		Deck deck = getShuffledDeck();
		
		List<Card> hand = new ArrayList<Card>();
		
		Card firstCard = deck.deal();
		
		if (firstCard == null) {
			return "twentyOne";
		}
		
		firstCard.flip();
		hand.add(firstCard);
		hand.add( deck.deal() );
		
		map.addAttribute("hand", hand);
		map.addAttribute("deck", deck);
		
		return "twentyOne";
	}
	
	@RequestMapping(path="/hit", method=RequestMethod.GET)
	public String hit(ModelMap map) {
		
		if (!map.containsKey("deck") || !map.containsKey("hand")) {
			return "redirect:/game";
		}
		
		Deck deck = (Deck) map.get("deck");
		Card nextCard = deck.deal();
		nextCard.flip();
		((List<Card>) map.get("hand")).add( nextCard );
		return "twentyOne";
	}
	
	@RequestMapping(path="/stand", method=RequestMethod.GET)
	public String stand(ModelMap map) {
	
		if (!map.containsKey("deck") || !map.containsKey("hand")) {
			return "redirect:/game";
		}
		
		List<Card> hand = (List<Card>) map.get("hand");
		
		hand.get(1).flip();
		
		int total = totalHand(hand);
		
		map.addAttribute("total", total);
		
		if (total <= 21) {
			map.addAttribute("result", "You Win!");
		} else {
			map.addAttribute("result", "Sorry you busted!");
		}
		
		return "twentyOne";
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
	
	
	private Deck getShuffledDeck() {
		Deck deck = new Deck();
		deck.shuffle();
		return deck;
	}
}
