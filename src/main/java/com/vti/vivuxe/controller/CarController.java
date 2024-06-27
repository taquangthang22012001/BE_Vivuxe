package com.vti.vivuxe.controller;

import com.vti.vivuxe.Form.CarCreate;
import com.vti.vivuxe.dto.request.CarDto;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.exception.DuplicateFieldException;
import com.vti.vivuxe.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/api/cars")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/api/cars/create")
    public CarDto createCar(@RequestBody CarCreate carCreate) {
       return carService.createCar(carCreate);
    }

    @GetMapping("/api/cars/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return  carService.getCarById(id);
    }
    @PutMapping("/api/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            return ResponseEntity.ok(carService.updateCar(id, car));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("api/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCar(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
