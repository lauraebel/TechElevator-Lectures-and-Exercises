package com.techelevator.person;

public class Person {

private String firstName;

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

private String lastName;

private int age;
	
public String getFullName() {
	return firstName + " " + lastName;
}
	
public boolean isAdult() {
	if (age >= 18) {
		return true;
	}
	else return false;
}
}
