package com.vti.vivuxe.controller;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.admin.CarDTO;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping()
    public CarDTO createCar(@RequestBody CarCreationRequest carCreationRequest) {
       return carService.createCar(carCreationRequest);
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Long id) {
        return  carService.getCarById(id);
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
