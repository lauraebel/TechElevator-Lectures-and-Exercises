package com.techelevator;

public class Dog {

	private String name;
	private String breed;
	private int age;
	
	public Dog(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Dog)) {
			return false;
		}
		Dog other = (Dog) obj;
		if (!this.name.equals(other.getName())) {
			return false;
		}
		if (!this.breed.equals(other.getBreed())) {
			return false;
		}
		if (this.age != other.getAge()) {
			return false;
		}
		return true;
	}
	
	
	
}
