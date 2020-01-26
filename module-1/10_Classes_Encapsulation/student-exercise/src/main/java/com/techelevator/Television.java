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
				
			}
			
		} else return;
		//if on between >=3 and <= 18
	}
	
	public void channelUp() {
		if (isOn) {
			currentChannel ++;
		} 
		//if on += 1
		//if >18 set to 3
	}
	
	public void channelDown() {
		if (isOn) {
			currentChannel--;
		}
		//if on -= 1
		//if <3 (currentChannel) set to 18
	}
	
	public void raiseVolume() {
		//if on += 1
		//<= 10
	}
	
	public void lowerVolume() {
		//if on -= 1
		//<=10
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
