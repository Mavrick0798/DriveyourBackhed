package com.driveyourway.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driveyourway.model.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
	
//	@Query("select c.*, w.wish_list_id from car as c, wishlist as w where w.car_id = c.car_id and w.user_id = ?0")
//	public List<Car> findAllCarsByUserId(Integer userId);
	
	public List<Wishlist> findByUserId(Integer userId);
}
