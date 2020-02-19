package com.techelevator.inventory.report;

import com.techelevator.transaction.TransactionResult;

public interface SalesReportWriter {

	void write(TransactionResult result);
}
