package com.techelevator.inventory.report;

public interface LogWriter {

	void write(String message, double amount, double newBalance);
}
