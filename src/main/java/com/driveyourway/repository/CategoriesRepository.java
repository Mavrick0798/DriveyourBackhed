package com.driveyourway.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driveyourway.model.Categories;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Integer> {

}
