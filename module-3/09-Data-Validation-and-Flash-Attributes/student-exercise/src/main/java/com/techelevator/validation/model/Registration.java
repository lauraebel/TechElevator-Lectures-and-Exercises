package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {

	@NotBlank(message="Please Provide a First Name")
	@Size(max=20, message="Cannot Be More Than 20 Letters")
	private String firstName;
	
	@NotBlank(message="Please Provide a Last Name")
	@Size(max=20, message="Cannot Be More Than 20 Letters")
	private String lastName;
	
	@NotBlank(message="Please Provide an Email")
	@Email(message="Invalid Email Address. Please Try Again")
	private String email;
	
	@NotBlank(message="Required To Confirm Email")
	private String confirmEmail;
	
	@NotBlank(message="You Must Choose a Password")
	@Size(min=8, message="Password Must Be At Least 8 Characters")
	private String password;
	
	@NotBlank(message="Required To Confirm Password")
	@Size(min=8, message="Password Must Be At Least 8 Characters")
	private String confirmPassword;

	@NotNull(message="Please Provide a Date of Birth")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthdate;
	
	@NotNull(message="You Must Select a Number Of Tickets")
	@Min(value=1, message="Number Of Tickets Must Be At Least 1")
	@Max(value=10, message="Cannot Exceed 10 Tickets")
	private int tickets;
	
	private boolean emailMatching; 
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(confirmEmail);
		} else {
			return false;
		}
	}
	
	private boolean passwordMatching; 
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(confirmPassword);
		} else {
			return false;
		}
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}	
	public void setEmailMatching(boolean emailMatching) {
		this.emailMatching = emailMatching;
	}
	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}
	
}
