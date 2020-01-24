package com.techelevator.staticExample;

public class CashRegister {

	private static double storeBalance = 0;
	private static int storeTransactions = 0;
	
	private String name;
	private double registerBalance;
	private int registerTransactions;
	
	public CashRegister(String name) {
		this.name = name;
	}

	public void makeSale(double amount) {
		this.registerBalance += amount;
		this.registerTransactions++;
		
		storeBalance += amount;
		storeTransactions++;
	}
	
	
	public static double getStoreBalance() {
		return storeBalance;
	}
	
	public static int getStoreTransactions() {
		return storeTransactions;
	}
	
	public String getName() {
		return name;
	}

	public double getRegisterBalance() {
		return registerBalance;
	}

	public int getRegisterTransactions() {
		return registerTransactions;
	}
	
	
	
}
