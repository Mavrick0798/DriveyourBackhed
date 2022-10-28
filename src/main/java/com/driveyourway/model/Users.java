package com.driveyourway.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer userId;
	String email;
	String password;
	String fullName;
	String street;
	String city;
	String state;
	String country;
	Integer pincode;
	String image;
	Long contact;
	Date addedOn;
	
	String subscriptionName;
	Date subscriptionExpiry;
	
	public Users() {
	
	}
	
	
	public Users(Integer userId, String subscriptionName, Date subscriptionExpiry) {
		this.userId = userId;
		this.subscriptionName = subscriptionName;
		this.subscriptionExpiry = subscriptionExpiry;
	}



	public Users(Integer userId, String email, String password, String fullName, String street, String city,
			String state, String country, Integer pincode, String image, Long contact, Date addedOn,
			String subscriptionName, Date subscriptionExpiry) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.image = image;
		this.contact = contact;
		this.addedOn = addedOn;
		this.subscriptionName = subscriptionName;
		this.subscriptionExpiry = subscriptionExpiry;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	public Date getSubscriptionExpiry() {
		return subscriptionExpiry;
	}
	public void setSubscriptionExpiry(Date subscriptionExpiry) {
		this.subscriptionExpiry = subscriptionExpiry;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", image=" + image + ", contact=" + contact + ", addedOn=" + addedOn + ", subscriptionName="
				+ subscriptionName + ", subscriptionExpiry=" + subscriptionExpiry + "]";
	}
}
