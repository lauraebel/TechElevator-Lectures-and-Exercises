package com.techelevator.money;

import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.money.denominations.*;

public class ChangeMaker {

	private final Money[] monies;
	
	public ChangeMaker(Money[] monies) {
		this.monies = monies;
	}
	
	/**
	 * Determines the best number and coins to return as change using the passed balance.
	 * The resulting Map contains the Coin type as a Key and the count of each coin type as the value
	 * @param balance
	 * @return
	 */
	public Map<Money, Integer> makeChange(double balance) {
		
		int amount = (int)(balance * 100);
		
		Map<Money, Integer> change = new LinkedHashMap<Money, Integer>();
		
		for (Money coin : monies) {
			if (amount <= 0) { break; }
			int cnt = amount / coin.getValue();
			if (cnt > 0) {
				amount = amount % (coin.getValue() * cnt);
				change.put(coin, cnt);
			}
		}
		
		return change;
		
	}
	
}
