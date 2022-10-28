package com.driveyourway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer cartId;
	Integer carId;
	Integer userId;
	
	public Cart() {
		
	}

	public Cart(Integer cartId, Integer carId, Integer userId) {
		this.cartId = cartId;
		this.carId = carId;
		this.userId = userId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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
		return "Cart [cartId=" + cartId + ", carId=" + carId + ", userId=" + userId + "]";
	}
	
	
	
}
