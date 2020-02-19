package com.techelevator.contacts;

public class Address {

	private int addressId;
	private String streetLineOne;
	private String streetLineTwo;
	private String city;
	private String district;
	private String postalCode;
	private String country;
	private String type;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetLineOne() {
		return streetLineOne;
	}
	public void setStreetLineOne(String streetLineOne) {
		this.streetLineOne = streetLineOne;
	}
	public String getStreetLineTwo() {
		return streetLineTwo;
	}
	public void setStreetLineTwo(String streetLineTwo) {
		this.streetLineTwo = streetLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetLineOne=" + streetLineOne + ", streetLineTwo="
				+ streetLineTwo + ", city=" + city + ", district=" + district + ", postalCode=" + postalCode
				+ ", country=" + country + ", type=" + type + "]";
	}
	
	
	
}
