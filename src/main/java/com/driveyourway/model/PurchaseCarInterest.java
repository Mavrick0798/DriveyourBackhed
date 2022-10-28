package com.driveyourway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseCarInterest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	Integer carId;
	Integer buyerUserId;
	Integer sellerUserId;
	Integer proposedPrice;
	String message;
	
	public PurchaseCarInterest() {
	
	}
	
	public PurchaseCarInterest(Integer id, Integer carId, Integer buyerUserId, Integer sellerUserId, Integer proposedPrice,
			String message) {
		this.id = id;
		this.carId = carId;
		this.buyerUserId = buyerUserId;
		this.sellerUserId = sellerUserId;
		this.proposedPrice = proposedPrice;
		this.message = message;
	}
	
	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getBuyerUserId() {
		return buyerUserId;
	}
	
	public void setBuyerUserId(Integer buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public Integer getSellerUserId() {
		return sellerUserId;
	}
	
	public void setSellerUserId(Integer sellerUserId) {
		this.sellerUserId = sellerUserId;
	}
	
	public Integer getProposedPrice() {
		return proposedPrice;
	}
	
	public void setProposedPrice(Integer proposedPrice) {
		this.proposedPrice = proposedPrice;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PurchaseCarInterest [id=" + id + ", carId=" + carId + ", buyerUserId=" + buyerUserId + ", sellerUserId="
				+ sellerUserId + ", proposedPrice=" + proposedPrice + ", message=" + message + "]";
	}
	
	
}
