package com.vti.vivuxe.controller;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.CarDTO;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
		return new ResponseEntity<>("Create Car Successfully!", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public CarDTO getCarById(@PathVariable Long id) {
		return carService.getCarById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
		try {
			return ResponseEntity.ok(carService.updateCar(id, car));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
		try {
			carService.deleteCar(id);
			return ResponseEntity.noContent().build();
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
