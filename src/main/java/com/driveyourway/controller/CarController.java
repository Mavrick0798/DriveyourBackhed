package com.driveyourway.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.driveyourway.model.Car;
import com.driveyourway.model.Response;
import com.driveyourway.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4300" })
public class CarController {

	@Autowired
	CarRepository repository;

	final String TAG = "Car";

	@PostMapping(path = "/add")
	public Response<Car> addCar(@RequestParam Integer carId, @RequestParam String name, @RequestParam String description,
			@RequestParam String location, @RequestParam String offers, @RequestParam Integer userId,
			@RequestParam List<String> images, @RequestParam Integer categoryId, @RequestParam Integer thumnailImage,
			@RequestParam Integer price, @RequestParam Date addedOn,
			@RequestParam Integer rating) {
		try {

			Date date = new Date();

			Car car = new Car(null, name, description, location, offers, userId, images, categoryId, thumnailImage, price,
					date, rating);
			System.out.println(car.toString());
			repository.save(car);

			return new Response<Car>(101, TAG + " Saved Successfully at " + date, new ArrayList<Car>() {
				{
					add(car);
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Response<Car>(202, "", null);
		}

	}

	@GetMapping(path = "/get")
	public Response<Car> getCars() {

		ArrayList<Car> list = new ArrayList<Car>();
		repository.findAll().forEach((car) -> list.add(car));

		Date date = new Date();
		return new Response<Car>(101, list.size() + " " + TAG + "s Fetched Successfully at " + date, list);

	}

	@GetMapping(path = "/get/{id}")
	public Response<Car> getCarById(@PathVariable("id") Integer id) {

		ArrayList<Car> list = new ArrayList<Car>();
		Car car = repository.findById(id).get();
		list.add(car);

		Date date = new Date();
		return new Response<Car>(101, TAG + " Fetched Successfully at " + date, list);

	}

	@GetMapping(path = "/get/{id}/user-cars")
	public Response<Car> getUserCarsByUserId(@PathVariable("id") Integer id) {

		List<Car> list = repository.findByUserID(id);

		Date date = new Date();
		return new Response<Car>(101, TAG + " Fetched Successfully at " + date, list);

	}

	@GetMapping(path = "/get/{id}/cars")
	public Response<Car> getCarByCategoryId(@PathVariable("id") Integer id) {

		List<Car> list = repository.findByCategoryId(id);
		// list.add(car);

		Date date = new Date();
		return new Response<Car>(101, TAG + " Fetched Successfully at " + date, list);

	}

	@PostMapping(path = "/update")
	public Response<Car> updateCar(@RequestParam Integer carId, @RequestParam String name,
			@RequestParam String description, @RequestParam String location,
			@RequestParam String offers, @RequestParam Integer userId,
			@RequestParam List<String> images, @RequestParam Integer categoryId, @RequestParam Integer thumnailImage,
			@RequestParam Integer price, @RequestParam Date addedOn,
			@RequestParam Integer rating) {
		Date date = new Date();

		Car car = new Car(carId, name, description, location, offers, userId, images, categoryId, thumnailImage, price,
				date, rating);
		repository.save(car);

		return new Response<Car>(101, TAG + " Updated Successfully at " + date, new ArrayList<Car>() {
			{
				add(car);
			}
		});

	}

	@GetMapping(path = "/delete/{id}")
	public Response<Car> deleteProduct(@PathVariable("id") Integer id) {

		Car car = new Car();
		car.setCarId(id);
		repository.delete(car);

		Date date = new Date();
		return new Response<Car>(101, TAG + " Deleted Successfully at " + date, null);

	}
}
