package com.techelevator.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservationsPage {

	private WebDriver webDriver;
	
	public ReservationsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public int getCountOfMatchingReservations(String reservedFor) {
		int count = 0;
		
		List<WebElement> cells = webDriver.findElements(By.tagName("td"));
		
		for (WebElement e : cells) {
			if (e.getText().equals(reservedFor)) {
				count++;
			}
		}
		
		return count;
	}
}
