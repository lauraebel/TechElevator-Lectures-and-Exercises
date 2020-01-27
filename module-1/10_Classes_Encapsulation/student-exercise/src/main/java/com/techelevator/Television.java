package com.techelevator;

public class Television {
	//Default = TV is off, Channel = 3, Volume = 2
	private int currentChannel = 3;
	private int currentVolume = 2;
	private boolean isOn = false;
	
	public void turnOff() {
		isOn = false;
	}
	
	public void turnOn() {
		isOn = true;
	
		}
	
	public void changeChannel(int newChannel) {
		if (isOn) {
			if (newChannel >=3 && newChannel <= 18) {
				currentChannel = newChannel;
			} 
		}
	}
	
	public void channelUp() {
		if (isOn) {
			if (currentChannel + 1 <= 18) {
			currentChannel ++;
			} else {
				currentChannel = 3;
		} 
		}
	}
	
	public void channelDown() {
		if (isOn) {
			if (currentChannel - 1 >= 3) {
			currentChannel --;
			} else {
				currentChannel = 18;
		} 
		}
	}
	
	
	public void raiseVolume() {
		if (isOn) {
			if (currentVolume + 1 <= 10) {
				currentVolume ++;
			} else {
				return;
			}
		}
	}
	
	public void lowerVolume() {
		if (isOn) {
			if (currentVolume - 1 >= 0) {
				currentVolume --;
			} else {
				return;
			}
		}
	}
	

	public int getCurrentChannel() {
		return currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public boolean isOn() {
		return isOn;
	}
	

}
