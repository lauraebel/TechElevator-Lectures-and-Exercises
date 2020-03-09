package com.techelevator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectVenuePage {

	private WebDriver webDriver;
	
	public SelectVenuePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public VenueDetailPage clickVenueLink(String venueName) {
		WebElement venueLink = webDriver.findElement(By.linkText(venueName));
		venueLink.click();
		return new VenueDetailPage(webDriver);
	}
}
