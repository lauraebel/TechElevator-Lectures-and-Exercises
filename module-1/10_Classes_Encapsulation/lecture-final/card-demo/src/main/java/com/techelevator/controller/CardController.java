package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.Card;
import com.techelevator.Deck;

@Controller
@SessionAttributes({"cards", "opponentCards"})
public class CardController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showTable() {
		return "cards";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String showCards(ModelMap map, int number) {
		Deck deck = getShuffledDeck();
		map.addAttribute("cards", dealCards(deck, number));
		map.addAttribute("opponentCards", dealCards(deck, number));
		return "cards";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/flipCard", method=RequestMethod.GET)
	public String flipCard(@RequestParam String cardRank, @RequestParam String cardSuit, @RequestParam String player, ModelMap map) {
		List<Card> cards;
		if (player.equals("opponent")) {
			cards = (List<Card>) map.get("opponentCards");
		} else {
			cards = (List<Card>) map.get("cards");
		}
		flipCard(cardRank, cardSuit, cards);
		return "redirect:/"; 
	}
	
	private void flipCard(String rank, String suit, List<Card> cards) {
		for (Card card : cards) {
			if (card.getRank().equals(rank) && card.getSuit().equals(suit)) {
				card.flip();
			}
		}
	}
	
	private List<Card> dealCards(Deck deck, int number) {
		
		List<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < number; i++) {
			Card next = deck.deal();
			cards.add(next);
		}
		return cards;
	}
	
	private Deck getShuffledDeck() {
		Deck deck = new Deck();
		deck.shuffle();
		return deck;
	}
	
}
