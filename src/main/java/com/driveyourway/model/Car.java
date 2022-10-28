package com.driveyourway.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer carId;
	String name;
	String description;
	String location;
	String offers;
	Integer userID;
	
	@ElementCollection 
    @CollectionTable(name = "Images", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "list")
	List<String> images;
	Integer categoryId;
	Integer thumnailImage;
	Integer price;	
	Date addedOn;
	Integer rating;
	
	public Car() {
		
	}

	public Car(Integer carId, String name, String description, String location, String offers, Integer userID,
			List<String> images, Integer categoryId, Integer thumnailImage, Integer price, Date addedOn,
			Integer rating) {
		this.carId = carId;
		this.name = name;
		this.description = description;
		this.location = location;
		this.offers = offers;
		this.userID = userID;
		this.images = images;
		this.categoryId = categoryId;
		this.thumnailImage = thumnailImage;
		this.price = price;
		this.addedOn = addedOn;
		this.rating = rating;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getThumnailImage() {
		return thumnailImage;
	}

	public void setThumnailImage(Integer thumnailImage) {
		this.thumnailImage = thumnailImage;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", offers=" + offers + ", userID=" + userID + ", images=" + images + ", categoryId=" + categoryId
				+ ", thumnailImage=" + thumnailImage + ", price=" + price + ", addedOn=" + addedOn + ", rating="
				+ rating + "]";
	}
	
}
