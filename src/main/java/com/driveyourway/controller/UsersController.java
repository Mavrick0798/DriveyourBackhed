package com.driveyourway.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driveyourway.model.Response;
import com.driveyourway.model.Users;
import com.driveyourway.repository.UsersRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4300" })
public class UsersController {

	@Autowired
	UsersRepository repository;
	
	final String TAG = "User";
	
	@PostMapping(path= "/login")
	public Response<Users> loginUser(@RequestParam String email, @RequestParam String password) {

		Date date = new Date();
		
		Users user = repository.findByEmailAndPassword(email, password).get();
		if(!user.getFullName().isEmpty()) {
			return new Response<Users>(101, TAG+" Logged In Successfully at "+date, new ArrayList<Users>() {{
				add(user);
			}});
		}else {
			return new Response<Users>(201, TAG+" Authentication Failed at "+date, null);
		}
		
	}
	
	@PostMapping(path= "/add")
	public Response<Users> addUser(@RequestParam String email, @RequestParam String password, @RequestParam String fullName, @RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String country, @RequestParam Integer pincode, @RequestParam String image, @RequestParam Long contact, @RequestParam String subscriptionName, @RequestParam Date subscriptionExpiry) {

		
		Date date = new Date();
		
		Users user = new Users(null, email, password, fullName, street, city, state, country, pincode, image, contact, date, subscriptionName, subscriptionExpiry);
		repository.save(user);
		
		return new Response<Users>(101, TAG+" Saved Successfully at "+date, new ArrayList<Users>() {{
			add(user);
		}});
		
	}
	
	@GetMapping(path="/get")
	public Response<Users> getUsers(){
		
		ArrayList<Users> list = new ArrayList<Users>();
		repository.findAll().forEach((user) -> list.add(user));
		
		Date date = new Date();
		return new Response<Users>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);
		
	}
	

	@GetMapping(path = "/get/{id}")
	public Response<Users> getUserById(@PathVariable("id") Integer id){
		
		ArrayList<Users> list = new ArrayList<Users>();
		Users user = repository.findById(id).get();
		list.add(user);
		
		Date date = new Date();
		return new Response<Users>(101, TAG+" Fetched Successfully at "+date, list);
		
	}
	
	@PostMapping(path= "/update/{id}/subscription")
	public Response<Users> updateUserSubscription(@RequestParam Integer userId, @RequestParam String subscriptionName, @RequestParam Date subscriptionExpiry) {

		Date date = new Date();
		
		Users user = repository.findById(userId).get();
		user.setSubscriptionName(subscriptionName);
		user.setSubscriptionExpiry(subscriptionExpiry);
		repository.save(user);
		
		return new Response<Users>(101, TAG+" Updated Successfully at "+date, new ArrayList<Users>() {{
			add(user);
		}});
		
	}
	
	@PostMapping(path= "/update")
	public Response<Users> updateUser(@RequestParam Integer userId, @RequestParam String email, @RequestParam String password, @RequestParam String fullName, @RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String country, @RequestParam Integer pincode, @RequestParam String image, @RequestParam Long contact, @RequestParam String subscriptionName, @RequestParam Date subscriptionExpiry) {

		
		Date date = new Date();
		
		Users user = new Users(userId, email, password, fullName, street, city, state, country, pincode, image, contact, date, subscriptionName, subscriptionExpiry);
		repository.save(user);
		
		return new Response<Users>(101, TAG+" Updated Successfully at "+date, new ArrayList<Users>() {{
			add(user);
		}});
		
	}
	
	
	
	@GetMapping(path = "/delete/{id}")
	public Response<Users> deleteUser(@PathVariable("id") Integer id){
		
		Users user = new Users();
		user.setUserId(id);
		repository.delete(user);
		
		Date date = new Date();
		return new Response<Users>(101, TAG+" Deleted Successfully at "+date, null);
		
	}
	
}
