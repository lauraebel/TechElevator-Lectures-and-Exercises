package com.techelevator.inventory.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.*;

public class TestLogWriterTest {
	
	private final static DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
	private static final String TEST_LOG_FILE = "test.log";
	private LogWriter log;
	private File file;
	
	@Before
	public void createTestFile() {
		file = new File(TEST_LOG_FILE);
		if (file.exists()) {
			file.delete();
		}
		log = new TextLogWriter(TEST_LOG_FILE);
	}
	
	@After
	public void cleanupTestFile() {
		file.delete();
	}
	
	@Test
	public void test_writing_to_file() {
		
		String testMessage = "TEST_MESSAGE";
		double testAmount = 1.05;
		double testNewBalance = 101.10;
		
		log.write(testMessage, testAmount, testNewBalance);
		
		List<String> lines = getLinesFromFile();
		
		Assert.assertEquals("Incorrect number of lines in file", 1, lines.size());
		asssertFileLineEquals(lines.get(0), testMessage, testAmount, testNewBalance );
	}
	
	@Test
	public void test_appending_to_file() {
		String lineOneMessage = "TEST_LINE_ONE";
		double lineOneAmount = 10.55;
		double lineOneBalance = 110.55;
		String lineTwoMessage = "TEST_LINE_TWO";
		double lineTwoAmount = 202.30;
		double lineTwoBalance = 312.85;
		
		log.write(lineOneMessage, lineOneAmount, lineOneBalance);
		log.write(lineTwoMessage, lineTwoAmount, lineTwoBalance);
		
		List<String> lines = getLinesFromFile();
		
		Assert.assertEquals("Incorrect number of lines in file", 2, lines.size());
		asssertFileLineEquals(lines.get(0), lineOneMessage, lineOneAmount, lineOneBalance );
		asssertFileLineEquals(lines.get(1), lineTwoMessage, lineTwoAmount, lineTwoBalance );
	}
	
	
	private void asssertFileLineEquals(String line, String expectedMessage, double expectedAmount, double expectedBalance) {
		String[] parts = line.split(" ");
		// [0] - date
		// [1] - time
		// [2] - AM / PM
		
		assertValidLogDate(parts[0] + " " + parts[1] + " " + parts[2]);
		
		// [3] - message
		Assert.assertEquals("Message was not as expected", expectedMessage + ":", parts[3].trim());
		
		// [4..n] spaces
		// [n] amount
		// [0..n] spaces
		// [n] balance
		boolean foundAmount = false;
		boolean foundBalance = false;
		int i = 4;
		for ( ; i < parts.length; i ++) {
			if (!parts[i].trim().equals("")) {
				if (!foundAmount) {
					assertValidAmount(expectedAmount, parts[i]);
					foundAmount = true;
				} else {
					assertValidAmount(expectedBalance, parts[i]);
					foundBalance = true;
				}
			}
		}
		
		Assert.assertTrue("Amount not found", foundAmount);
		Assert.assertTrue("Balance not found", foundBalance);
		
	}
	
	private void assertValidAmount(double expectedAmount, String actualAmount) {
		String expectedAmountStr = String.format("$%-7.2f", expectedAmount);
		Assert.assertEquals("Expected amounts did not match", expectedAmountStr.trim(), actualAmount.trim());
	}
	
	private void assertValidLogDate(String date) {
		
		LocalDateTime ldt = null;
		try {
			ldt = LocalDateTime.parse(date, timestampFormatter);
		} catch (DateTimeParseException e) {
			Assert.fail("Invalid date: " + date);
		} catch (Exception e) {
			Assert.fail("Unexpected exception formatting date: " + date);
		}
		Assert.assertNotNull(ldt);
		
	}
	
	
	private List<String> getLinesFromFile() {
		List<String> lines = new ArrayList<String>();
		
		try (Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
				lines.add(reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			Assert.fail("Failed to read test file: " + e.getMessage());
		}
		
		return lines;
	}
	

	
	
}
