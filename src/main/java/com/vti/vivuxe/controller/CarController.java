package com.vti.vivuxe.controller;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.CarDTO;
import com.vti.vivuxe.service.Car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping()

	public Page<CarDTO> getAllCars(Pageable pageable) {
		return carService.getAllCars(pageable);
	}

	@PostMapping()
	public ResponseEntity<?> createCar(@RequestBody CarCreationRequest request) {
		carService.createCar(request);
		return new ResponseEntity<>("Car Created Successfully!", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public CarDTO getCarById(@PathVariable Long id) {
		return carService.getCarById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody CarCreationRequest request) {
		carService.updateCar(id, request);
		return ResponseEntity.ok("Car updated Successfully!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return ResponseEntity.ok("Car deleted Successfully!");
	}
}
