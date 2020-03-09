package com.techelevator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VenueDetailPage {
	private WebDriver webDriver;
	
	public VenueDetailPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public VenueDetailPage enterSpaceId(String spaceId) {
		WebElement spaceIdField = webDriver.findElement(By.name("spaceId"));
		spaceIdField.sendKeys(spaceId);
		return this;
	}
	
	
	public VenueDetailPage enterNumberOfAttendees(String number) {
		WebElement numberOfAttendees = webDriver.findElement(By.name("numberOfAttendees"));
		numberOfAttendees.sendKeys(number);
		return this;
	}
	
	public VenueDetailPage enterStartDate(String startDate) {
		WebElement startDateField = webDriver.findElement(By.name("startDate"));
		startDateField.sendKeys(startDate);
		return this;
	}
	
	public VenueDetailPage enterEndDate(String endDate) {
		WebElement endDateField = webDriver.findElement(By.name("endDate"));
		endDateField.sendKeys(endDate);
		return this;
	}
	
	public VenueDetailPage enterReservedFor(String reservedFor) {
		WebElement reservedForField = webDriver.findElement(By.name("reservedFor"));
		reservedForField.sendKeys(reservedFor);
		return this;
	}
	
	public ReservationsPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.xpath("/html/body/div/form/input[7]"));
		submitButton.click();
		return new ReservationsPage(webDriver);
	}
}
