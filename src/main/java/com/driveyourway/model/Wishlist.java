package com.driveyourway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer wishListId;
	Integer carId;
	Integer userId;
	
	public Wishlist() {
		
	}

	public Wishlist(Integer wishListId, Integer carId, Integer userId) {
		this.wishListId = wishListId;
		this.carId = carId;
		this.userId = userId;
	}
	

	public Integer getWishListId() {
		return wishListId;
	}

	public void setWishListId(Integer wishListId) {
		this.wishListId = wishListId;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Wishlist [wishListId=" + wishListId + ", carId=" + carId + ", userId=" + userId + "]";
	}
	
	
	
}
