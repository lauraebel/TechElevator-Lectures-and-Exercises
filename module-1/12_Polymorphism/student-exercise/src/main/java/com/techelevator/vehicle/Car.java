package com.techelevator.vehicle;

public class Car implements Vehicle {

	private boolean hasTrailer;

	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}

	@Override
	public double calculateToll(int distance) {
		int toll = (int) (distance * .020);
		if (!hasTrailer) {
			return toll;
		}
		return toll += 1;
	}

	public boolean isHasTrailer() {
		return hasTrailer;
	}

	@Override
	public String getName() {
		if (hasTrailer) {
			return "Car With Trailer";
		}
		return "Car Without Trailer";
	}

}
