package com.techelevator.excelsior.menu;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.techelevator.excelsior.model.Reservation;
import com.techelevator.excelsior.model.Space;
import com.techelevator.excelsior.model.Venue;

public class Menu {

	Scanner scanner = new Scanner(System.in);

	public String displayMainMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1) List Venues");
		System.out.println("S) Search for a Space");
		System.out.println("Q) Quit");

		return getUserChoice("[1SQ]");
	}

	public String displayVenues(List<Venue> venues) {
		String regex = "(R";
		int counter = 1;

		System.out.println("Excelsior Venue List: ");
		for (Venue venue : venues) {
			System.out.println(counter + ") " + venue.getName());
			regex += "|" + counter;
			counter++;
		}

		regex += ")";

		System.out.println("R) Return to Previous Screen");
		System.out.println();
		System.out.println("Which venue would you like to view?");

		return getUserChoice(regex);

	}

	public String displayVenueDetails(Venue venue) {
		System.out.println();
		System.out.println(venue.getName());
		System.out.println("Location: " + venue.getCityName() + ", " + venue.getStateName());
		System.out.println();
		System.out.print("Categories: ");
		boolean isFirst = true;
		for (String category : venue.getCategories()) {
			if (!isFirst) {
				System.out.print(", " + category);
			} else {
				System.out.print(category);
				isFirst = false;
			}
		}
		System.out.println();
		System.out.println("\n" + venue.getDescription());
		System.out.println("\nWhat would you like to do next?");
		System.out.println("1) View Spaces");
		System.out.println("2) View Upcoming Reservations");
		System.out.println("R) Return to Previous Screen");

		return getUserChoice("[12R]");
	}

	public String displayVenueSpaces(Venue venue) {

		int indexVariable = 1;

		System.out.println();
		System.out.println(venue.getName());
		System.out.println();
		System.out.printf("%-2s %-30s %-12s %-12s %-15s %-20s\n", " ", "Name", "Open", "Close", "Daily Rate",
				"Max. Occupancy");
		for (Space space : venue.getSpaces()) {
			System.out.printf("%s %-30s %-12s %-12s $%-19.2f %-20d\n", "#" + indexVariable, space.getName(),
					getMonth(space.getOpenFrom()), getMonth(space.getOpenTo()), space.getDailyRate(),
					space.getMaxOccupancy());
			indexVariable++;
		}
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("1) Reserve a Space");
		System.out.println("R) Return to Previous Screen");

		return getUserChoice("[1R]");

	}

	public String displayThirtyDayReservations(List<Reservation> reservations) {
		System.out.println();
		if (reservations.size() == 0) {
			System.out.println("There are no reservations in the next 30 days for this venue.");
		} else {
			System.out.printf("%-35s %-35s %-15s %-15s\n", "Space", "Reserved For", "From", "To");
			for (Reservation reservation : reservations) {
				System.out.printf("%-35s %-35s %-15s %-15s\n", reservation.getSpace(), reservation.getReservedFor(),
						formatDateForDisplay(reservation.getStartDate()),
						formatDateForDisplay(reservation.getEndDate()));
			}
		}
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("R) Return to Previous Screen");
		System.out.println("Q) Quit");

		return getUserChoice("[RQ]");
	}

	public LocalDate getReservationStartDateFromUser() {

		String date;
		String validDateRegex = "^(((0[1-9]|1[012])/(0[1-9]|1\\d|2[0-8])"
				+ "|(0[13456789]|1[012])/(29|30)|(0[13578]|1[02])/31)/(19|"
				+ "[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|"
				+ "[13579][26])|(([2468][048]|[3579][26])00)))$";

		while (true) {
			System.out.println("When do you need the space? (MM/DD/YYYY) ");
			date = scanner.nextLine();

			if (date.matches(validDateRegex)) {

				LocalDate userDateChoice = LocalDate.parse(formatDateForParsing(date));
				if (userDateChoice.compareTo(LocalDate.now()) > 0) {
					return userDateChoice;
				} else {
					System.out.println();
					System.out.println("That date is before today. You can't book then, silly. Try again. \n");
				}
			} else {
				System.out.println();
				System.out.println("That is not a valid date. Try MM/DD/YYYY format. \n");
			}
		}
	}

	public LocalDate getReservationEndDateFromUser(LocalDate date) {

		System.out.println("How many days will you need the space? ");

		String daysToStay;

		while (true) {
			daysToStay = scanner.nextLine();
			if (daysToStay.matches("^\\d+$")) {
				LocalDate endDate = date.plus(Long.parseLong(daysToStay), ChronoUnit.DAYS);
				return endDate;
			} else {
				System.out.println(
						"You have entered an invalid value to represent how many days you want to stay. Please try again.");
			}
		}

	}

	public int getNumberOfAttendeesFromUser() {
		System.out.println("How many people will be in attendance? ");

		String numberOfAttendees;

		while (true) {
			numberOfAttendees = scanner.nextLine();
			if (numberOfAttendees.matches("^\\d+$")) {
				return Integer.parseInt(numberOfAttendees);
			} else {
				System.out.println(
						"You have entered an invalid value to represent your number of attendees. Please try again.");
			}
		}
	}

	public boolean getAccessibilityFromUser() {
		System.out.println("Does the space require accessibility accommodations (Y/N)?");

		String isAccessible;

		while (true) {
			isAccessible = scanner.nextLine();
			if (isAccessible.matches("[YN]")) {
				return isAccessible.equals("Y") ? true : false;
			} else {
				System.out.println("Invalid option. Please enter Y or N.");
			}
		}
	}

	public double getDailyBudgetFromUser() {
		System.out.println("What is your daily budget for the event? (To the nearest dollar amount)");

		String dailyBudget;

		while (true) {
			dailyBudget = scanner.nextLine();
			if (dailyBudget.matches("^\\d+$")) {
				return Double.parseDouble(dailyBudget);
			} else {
				System.out.println("Invalid option. Please enter whole number.");
			}
		}
	}

	public String getCategoryFromUser(List<String> categories) {
		System.out.println();
		System.out.println("Which of the categories would you like to include?");

		String regex = "(N";
		int counter = 1;

		for (String category : categories) {
			System.out.println(counter + ") " + category);
			regex += "|" + counter;
			counter++;
		}

		regex += ")";

		System.out.println("N) None");
		System.out.println();

		return getUserChoice(regex);
	}

	public String displayAvailableSpacesToUser(List<Space> spaces, long lengthOfStay) {
		String regex = "(0";
		long venueId = spaces.get(0).getVenueId();
		int spacesToDisplayPerVenue = 5;
		System.out.println();
		System.out.println("The following spaces are available based on your needs:");
		System.out.println();
		System.out.println(spaces.get(0).getVenueName());
		System.out.printf("%-10s %-35s %-12s %-12s %-15s %-15s\n", "Space #", "Name", "Daily Rate", "Max. Occup.",
				"Accessible?", "Total Cost");
		for (Space space : spaces) {
			if (space.getVenueId() != venueId) {
				venueId = space.getVenueId();
				spacesToDisplayPerVenue = 5;
				System.out.println();
				System.out.println(space.getVenueName());
				System.out.printf("%-10s %-35s %-12s %-12s %-15s %-15s\n", "Space #", "Name", "Daily Rate",
						"Max. Occup.", "Accessible?", "Total Cost");
			}
			if (spacesToDisplayPerVenue > 0) {
				System.out.printf("%-10d %-35s $%-12.2f %-12d %-15s $%-15.2f\n", space.getId(), space.getName(),
						space.getDailyRate(), space.getMaxOccupancy(), space.isAccessible() ? "Yes" : "No",
						(space.getDailyRate() * lengthOfStay));
				regex = regex + "|" + space.getId();
			}
			spacesToDisplayPerVenue--;
		}

		System.out.println();
		regex += ")";
		return regex;

	}

	public String displayNoAvailableSpaces() {
		System.out.println();
		System.out.println("Sorry, but there are no available spaces that meet your needs.");
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("1) Try another search");
		System.out.println("Q) Quit");

		return getUserChoice("[1Q]");
	}

	public int getSpaceIdFromUser(String regex) {
		System.out.println("Which space would you like to reserve (enter 0 to cancel)?");

		return Integer.parseInt(getUserChoice(regex));
	}

	public String getReservedForFromUser() {
		System.out.println("Who is this reservation for?");
		return scanner.nextLine();
	}

	public void displayReservationDetailsToUser(Reservation reservation) {
		System.out.println("Thanks for submitting your reservation! The details for you event are listed below:");
		System.out.println();
		System.out.printf("%25s %-25d\n", "Confirmation #: ", reservation.getId());
		System.out.printf("%25s %-25s\n", "Venue: ", reservation.getVenue());
		System.out.printf("%25s %-25s\n", "Space: ", reservation.getSpace());
		System.out.printf("%25s %-25s\n", "Reserved For: ", reservation.getReservedFor());
		System.out.printf("%25s %-25d\n", "Attendees: ", reservation.getNumberOfAttendees());
		System.out.printf("%25s %-25s\n", "Arrival Date: ", formatDateForDisplay(reservation.getStartDate()));
		System.out.printf("%25s %-25s\n", "Departure Date: ", formatDateForDisplay(reservation.getEndDate()));
		System.out.printf("%25s $%-25.2f\n", "Total Cost: ", reservation.getTotalCost());
	}

	public String displayExitMenu() {
		System.out.println();
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("R) Return to Main Menu");
		System.out.println("Q) Quit");

		return getUserChoice("[QR]");

	}

	private String formatDateForParsing(String dateString) {
		return dateString.substring(6) + "-" + dateString.substring(0, 2) + "-" + dateString.substring(3, 5);
	}

	private String formatDateForDisplay(LocalDate date) {
		String dateString = String.valueOf(date);
		dateString = dateString.substring(5, 7) + "/" + dateString.substring(8) + "/" + dateString.substring(0, 4);
		return dateString;
	}

	private String getUserChoice(String regex) {
		String userInput = "";

		while (true) {
			userInput = scanner.nextLine();
			if (userInput.matches(regex)) {
				break;
			} else {
				System.out.println("\nInvalid Option. Try again. \n");
			}
		}
		return userInput;
	}

	private String getMonth(int month) {
		if (month == 0) {
			return "";
		}
		return new DateFormatSymbols().getMonths()[month - 1];
	}

}
