package com.techelevator.elevator;

public class Elevator {

	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen = true;
	
	public Elevator(int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
	}
	
	
	public void openDoor() {
		this.doorOpen = true;
	}
	
	public void closeDoor() {
		this.doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if (!doorOpen  && desiredFloor > currentFloor) {
			this.currentFloor = desiredFloor;
		}
		
	}
	
	public void goDown(int desiredFloor) {
		if (!doorOpen && desiredFloor >= 1) {
			this.currentFloor = desiredFloor;
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
