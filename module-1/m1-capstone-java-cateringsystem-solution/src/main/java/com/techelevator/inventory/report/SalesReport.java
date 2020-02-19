package com.techelevator.inventory.report;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SalesReport {

	private Map<String, SalesReportEntry> lines = new LinkedHashMap<String, SalesReportEntry>();
	private double salesTotal = 0;
	

	public boolean containsItem(String itemName) {
		return lines.containsKey(itemName.trim());
	}
	
	public Set<Entry<String, SalesReportEntry>> getSalesReportEntries() {
		return lines.entrySet();
	}
	
	public double getSalesTotal() {
		return salesTotal;
	}
	public void addToSalesTotal(double amountToAdd) {
		this.salesTotal += amountToAdd;
	}

	
	public void addSalesReportEntry(String name, String amount, String cost) {
		int quantity = Integer.parseInt(amount.trim());
		String costClean = cost.trim().startsWith("$") ? cost.trim().substring(1) : cost.trim();
		double price = Double.parseDouble(costClean);
		addSalesReportEntry(name, quantity, price);
	}
	
	public void addSalesReportEntry(String name, int quantity, double cost) {
		
		String nameTrimed = name.trim();
		SalesReportEntry entry;
		
		if (lines.containsKey(nameTrimed)) {
			entry = lines.get(nameTrimed);
			entry.addToCost(cost);
			entry.addToQuantity(quantity);
		} else {
			entry = new SalesReportEntry(quantity, cost);
		}
		lines.put(nameTrimed, entry);
		
	}
	
	
}
