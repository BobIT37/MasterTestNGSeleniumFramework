package com.masterframework.pom.objects;

public class BillingAddress {
	
	private String firstname;
	private String lastname;
	private String addressLineOne;
	private String city;
	private String postalCode;
	private String email;
	private String country;
	private String state;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public BillingAddress() {
		
	}
	
	public BillingAddress(String firstname, String lastname, String addressLineOne, String city, String postalCode,
			String email) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.addressLineOne = addressLineOne;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public BillingAddress setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public String getLastname() {
		return lastname;
	}
	public BillingAddress setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public BillingAddress setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
		return this;
	}
	public String getCity() {
		return city;
	}
	public BillingAddress setCity(String city) {
		this.city = city;
		return this;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public BillingAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public BillingAddress setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	

}
