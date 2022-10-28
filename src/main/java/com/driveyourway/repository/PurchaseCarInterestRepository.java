package com.driveyourway.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.driveyourway.model.PurchaseCarInterest;

public interface PurchaseCarInterestRepository extends CrudRepository<PurchaseCarInterest, Integer> {

	public List<PurchaseCarInterest> findByBuyerUserId(Integer buyerUserId);
}
