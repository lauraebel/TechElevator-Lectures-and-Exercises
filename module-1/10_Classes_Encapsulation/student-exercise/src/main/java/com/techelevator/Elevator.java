package com.techelevator;
public class Elevator {
	
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen = false;
	
	public Elevator(int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
		this.currentFloor = 1;
	}
	
	public void openDoor() {
	     doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	//if the door is closed, the current floor needs to become the desired floor 
	//desired floor cannot be above the last floor or below the 1st floor
	//^^^^ totalNumberOfFloors is how many floors are available to the elevator
	
	public void goUp(int desiredFloor) {
		if (doorOpen) {
			// if (desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
			for (int i = currentFloor; i <= numberOfFloors; i++) {
				if (currentFloor != desiredFloor) {
					continue;
				} else if (currentFloor == desiredFloor) {
					break;
				}
			}
		} else
			return;
	}

	public void goDown(int desiredFloor) {
		if (doorOpen) {
			for (int i = currentFloor; i >= 1; i--) {
				if (currentFloor != desiredFloor) {
					continue;
				}
				if (currentFloor == desiredFloor) {
					break;
				} else
					return;
			}
		}
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	
	

}
