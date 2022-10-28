package com.driveyourway.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driveyourway.model.PurchaseCarInterest;
import com.driveyourway.model.Response;
import com.driveyourway.repository.PurchaseCarInterestRepository;

@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4300" })
public class PurchaseCarInterestController {

  @Autowired
  PurchaseCarInterestRepository repository;

  final String TAG = "PurchaseCarInterestController";

  @PostMapping(path= "/add")
	public Response<PurchaseCarInterest> addInterest(@RequestParam Integer carId, @RequestParam Integer buyerUserId, @RequestParam Integer sellerUserId, @RequestParam Integer proposedPrice, @RequestParam String message) {
		Date date = new Date();
		PurchaseCarInterest interest = new PurchaseCarInterest(null, carId, buyerUserId, sellerUserId, proposedPrice, message);

		repository.save(interest);
		
		return new Response<PurchaseCarInterest>(101, TAG+" Saved Successfully at "+date, null);
		
	}
	
	@GetMapping(path="/get")
	public Response<PurchaseCarInterest> getPurchaseCarInterests(){
		
		ArrayList<PurchaseCarInterest> list = new ArrayList<PurchaseCarInterest>();
		repository.findAll().forEach((interest) -> list.add(interest));
		
		Date date = new Date();
		return new Response<PurchaseCarInterest>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);	
	}

	@GetMapping(path = "/get/{id}")
	public Response<PurchaseCarInterest> getPurchaseCarInterestItemsByUserId(@PathVariable("id") Integer id){
		
		List<PurchaseCarInterest> list = repository.findByBuyerUserId(id);
//		PurchaseCarInterest interest = ;
//		list.add(interest);
		
		Date date = new Date();
		return new Response<PurchaseCarInterest>(101, TAG+" Fetched Successfully at "+date, list);
		
	}
	
	@PostMapping(path= "/update")
	public Response<PurchaseCarInterest> updateUserPurchaseCarInterest(@RequestParam Integer id,  @RequestParam Integer carId, @RequestParam Integer buyerUserId, @RequestParam Integer sellerUserId, @RequestParam Integer proposedPrice, @RequestParam String message) {
    Date date = new Date();
		PurchaseCarInterest interest = new PurchaseCarInterest(id, carId, buyerUserId, sellerUserId, proposedPrice, message);
		repository.save(interest);
		return new Response<PurchaseCarInterest>(101, TAG+" Updated Successfully at "+date, null);
		
	}
	
	@GetMapping(path = "/delete/{id}")
	public Response<PurchaseCarInterest> deleteItemFromUserPurchaseCarInterest(@PathVariable("id") Integer id){
		
		PurchaseCarInterest interest = new PurchaseCarInterest();
		interest.setId(id);
		repository.delete(interest);
		
		Date date = new Date();
		return new Response<PurchaseCarInterest>(101, TAG+" Deleted Successfully at "+date, null);
		
	}
}
