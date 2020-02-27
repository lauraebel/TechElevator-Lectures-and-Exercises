package com.techelevator;

import java.io.Serializable;

/*
 * A Java Bean is a class that encapsulates other objects into a single object (the bean).   
 * Generally they are simple data objects (like the data objects in the DAO Pattern).  However, 
 * they can have derived Getters and simple methods.  
 * 
 * Java Beans must have the following 3 characteristics
 * 
 * 1. Be Serializable - THIS IS OFTEN OMITTED.   Serialization means that it can be transformed into a String (Serialization) 
 *                      so it can be transferred to remote systems, and then the String can be used to reconstitute the 
 *                      values back into an Object (Deserialization).  Only the values of the member variables are serialized
 *                      and not the code.  
 *                      JavaBeans used with SpringMVC do not require Serialization.  
 *                      
 * 2. Have a Zero Argument Constructor - it can use the default constructor, but if it has constructor overrides then the
 *                                       zero-argument constructor must also be available.   
 *                                       
 * 3. Have private member variables with public access given using Getters and Setters that conform to the Java Standards. 
 */


/*
*  1. Implements Serializable
*  This rule is part of the Java Bean standard, but is often skipped in practice
*/
public class JavaBean implements Serializable {

	/**
	 * Serial Version UID required by Serializable Interface
	 * If the interface is omitted, then this can be omitted.
	 */
	private static final long serialVersionUID = 6443840947356395493L;
	
	/*
	 * All of it's member variables must be private.
	 */
	private String property1;
	private String property2;
	private int property3;
	
	/*
	 * 2. Has a Zero Argument constructor
	 * A Java Bean may have other other constructor overloads, but it MUST have the zero
	 * argument constructor
	 */
	public JavaBean() {
		
	}

	/*
	 * 3. Has Getters and Setters, that conform to the Java naming standards, that allow access to the private
	 *    member variables. 
	 */
	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public int getProperty3() {
		return property3;
	}

	public void setProperty3(int property3) {
		this.property3 = property3;
	}

	
}
