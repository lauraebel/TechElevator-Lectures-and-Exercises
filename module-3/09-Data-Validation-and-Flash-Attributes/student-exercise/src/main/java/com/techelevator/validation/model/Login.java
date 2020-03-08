package com.techelevator.validation.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Login {
	
	@NotBlank(message="Please Enter Your Email")
	@Email(message="Invalid Email Address. Please Try Again")
	private String email;
	
	@NotBlank(message="You Must Enter Your Password")
	@Size(min=8, message="Password Must Be At Least 8 Characters")
	private String password;

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}



