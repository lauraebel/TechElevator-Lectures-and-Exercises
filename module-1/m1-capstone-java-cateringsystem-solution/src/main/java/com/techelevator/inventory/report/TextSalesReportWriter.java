package com.techelevator.inventory.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.inventory.CartItem;
import com.techelevator.transaction.TransactionResult;


public class TextSalesReportWriter implements SalesReportWriter {

	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private File file;
	
	public TextSalesReportWriter(String filepath) {
		file = new File(filepath);
	}
	
	@Override
	public void write(TransactionResult result) {
		
		SalesReport report = getExistingReport();
		
		for (CartItem item : result.getPurchasedItems()) {
			report.addSalesReportEntry(item.getItem().getName(), item.getQuantity(), item.getTotalAmount());
		}
		
		report.addToSalesTotal( result.getTransactionTotal() );
		writeSalesReport(report);
	}
	
	private void writeSalesReport(SalesReport report) {
		
		try (PrintWriter printWriter = new PrintWriter(file);
				BufferedWriter writer = new BufferedWriter(printWriter)) {
			
			for (Entry<String, SalesReportEntry> entry : report.getSalesReportEntries()) {
				String formattedEntry = String.format("%-1s|%-1s|$%-3.2f%n", entry.getKey(),  entry.getValue().getQuantity(), entry.getValue().getCost());
				writer.write(formattedEntry);
			}
			
			writer.write(NEW_LINE);
			writer.write(String.format("**TOTAL SALES** $%-8.2f%n", report.getSalesTotal()));
			
		} catch (FileNotFoundException e) {
			throw new FileWriteException("Sales Report file not found", e);
		} catch (IOException e) {
			throw new FileWriteException("Failed to write to Sales Report", e);
		}
		
	}
	
	
	private SalesReport getExistingReport() {
		SalesReport report = new SalesReport();
		
		if (file.exists()) {
			try (Scanner reader = new Scanner(file)) {
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					if (line.length() == 0) {
						continue;
					} else if (line.contains("**")) {
						getTotalFromLine(report, line);
					} else {
						getEntryFromLine(report, line);
					}
				} 
			} catch (FileNotFoundException e) {
				throw new FileWriteException("Sales Report file not found", e);
			}
		}
		
		return report;
	}
	
	private void getEntryFromLine(SalesReport report, String line) {
		String[] parts = line.split("\\|");
		report.addSalesReportEntry(parts[0], parts[1], parts[2]);
	}
	
	private void getTotalFromLine(SalesReport report, String line) {
		String[] parts = line.split("\\$");
		double totalAmount = Double.parseDouble(parts[1]);
		report.addToSalesTotal(totalAmount);
	}
	

	
	
	
	

}
