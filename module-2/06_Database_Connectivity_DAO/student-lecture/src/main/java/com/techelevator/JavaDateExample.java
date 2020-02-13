package com.techelevator;

import java.time.LocalDate;
import java.time.MonthDay;

public class JavaDateExample {

	public static void main(String[] args) {
		doBirthdayCalculationsUsingJava8Classes();
	}

	private static void doBirthdayCalculationsUsingJava8Classes() {
		LocalDate javaBirthdate = LocalDate.of(1995, 5, 23);
		MonthDay javaBirthday = MonthDay.from(javaBirthdate);
		if (javaBirthday.equals(MonthDay.now())) {
			System.out.println("Happy Birthday Java!");
		} else {
			LocalDate today = LocalDate.now();
			long daysUntilBirthday = javaBirthdate.getDayOfYear() - today.getDayOfYear();
			if (daysUntilBirthday < 0) {
				daysUntilBirthday = 365 + daysUntilBirthday;
			}
			System.out.println(daysUntilBirthday + " days until Java's birthday!");
		}
	}

}
