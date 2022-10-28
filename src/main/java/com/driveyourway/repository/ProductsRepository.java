package com.driveyourway.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driveyourway.model.Car;

@Repository
public interface ProductsRepository extends CrudRepository<Car, Integer> {

}
