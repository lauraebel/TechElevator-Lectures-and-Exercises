package com.techelevator;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.pageobjects.ReservationsPage;
import com.techelevator.pageobjects.SelectVenuePage;

public class CateringSystemEndToEndTest {

	private static WebDriver webDriver;
	private SelectVenuePage selectVenuePage;
	
	
	@BeforeClass
	public static void openWebBrowser() {
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/selenium-catering-lecture-10-final/");
		selectVenuePage = new SelectVenuePage(webDriver);
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void make_reservation() {
		String reservedFor = "Sally";
		ReservationsPage reservations = selectVenuePage.clickVenueLink("Blue Nomad Outpost")
						.enterSpaceId("23")
						.enterNumberOfAttendees("2")
						.enterStartDate("03/11/2020")
						.enterEndDate("03/13/2020")
						.enterReservedFor(reservedFor)
						.submitForm();
		
		Assert.assertTrue(reservations.getCountOfMatchingReservations(reservedFor) > 0);
	}
}
