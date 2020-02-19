package com.techelevator.inventory.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextLogWriter implements LogWriter {

	// TODO: Needs Test Cases
	
	private File file;
	private final static DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
	
	public TextLogWriter(String filepath) {
		 file = new File(filepath);
	}
	
	@Override
	public void write(String message, double amount, double newBalance) {
		
		String logEntry = String.format("%22s %-10s: $%-7.2f $%-7.2f%n", getTimestamp(), message, amount, newBalance);
		
		try (FileWriter writer = new FileWriter(file, file.exists())) {
			writer.write(logEntry);
		} catch (IOException e) {
			throw new FileWriteException("Unable to write to log file", e);
		}
		
	}
	
	private String getTimestamp() {
		return LocalDateTime.now().format(timestampFormatter);
	}



}
