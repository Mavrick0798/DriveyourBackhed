package com.driveyourway.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driveyourway.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
	
	public List<Car> findByCategoryId(Integer categoryId);
	public List<Car> findByUserID(Integer userID);
}
