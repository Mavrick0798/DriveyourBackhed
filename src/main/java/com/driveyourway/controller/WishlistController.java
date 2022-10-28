package com.driveyourway.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.driveyourway.model.Car;
import com.driveyourway.model.Response;
import com.driveyourway.model.Wishlist;
import com.driveyourway.repository.CarRepository;
import com.driveyourway.repository.WishlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4300" })
public class WishlistController {

  @Autowired
  WishlistRepository repository;
  
  @Autowired
  CarRepository carRepository;
  
  final String TAG = "Wishlist";

  @PostMapping(path= "/add")
	public Response<Wishlist> addItemToWishlist(@RequestParam Integer carId, @RequestParam Integer userId) {
		Date date = new Date();
		
		Wishlist wishlist = new Wishlist(null, carId, userId);
		repository.save(wishlist);
		
		return new Response<Wishlist>(101, TAG+" Saved Successfully at "+date, null);
		
	}
	
	@GetMapping(path="/get")
	public Response<Wishlist> getWishlistItems(){
		
		ArrayList<Wishlist> list = new ArrayList<Wishlist>();
		repository.findAll().forEach((wishlist) -> list.add(wishlist));
		
		Date date = new Date();
		return new Response<Wishlist>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);	
	}

	// Get All Wishlist Cars Details
	@GetMapping(path = "/get/{id}")
	public Response<Map<String, Object>> getWishlistItemsById(@PathVariable("id") Integer id){
		
		List<Wishlist> list = repository.findByUserId(id);
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		for (Wishlist wish: list) {
			Map<String, Object> objMap = new HashMap<String, Object>();
			Car car = carRepository.findById(wish.getCarId()).get();
			objMap.put("car", car);
			objMap.put("wishlist", wish);
			map.add(objMap);
		}
		
		Date date = new Date();
		return new Response<Map<String, Object>>(101, TAG+" Fetched Successfully at "+date, map);
		
	}
	
	@PostMapping(path= "/update")
	public Response<Wishlist> updateWishlist(@RequestParam Integer WishlistId, @RequestParam Integer carId, @RequestParam Integer userId) {
    Date date = new Date();
		Wishlist wishlist = new Wishlist(WishlistId, carId, userId);
		repository.save(wishlist);
		
		return new Response<Wishlist>(101, TAG+" Updated Successfully at "+date, null);
		
	}
	
	@GetMapping(path = "/delete/{id}")
	public Response<Wishlist> deleteItemFromUserWishlist(@PathVariable("id") Integer id){
		
		Wishlist wishlist = new Wishlist();
		wishlist.setWishListId(id);
		repository.delete(wishlist);
		
		Date date = new Date();
		return new Response<Wishlist>(101, TAG+" Deleted Successfully at "+date, null);
		
	}
}
