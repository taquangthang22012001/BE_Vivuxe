package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.admin.CarDTO;
import com.vti.vivuxe.entity.Car;

import java.util.List;

public interface CarServiceImp {
    List<CarDTO> getAllCars();
    CarDTO createCar(CarCreationRequest carCreationRequest);
    CarDTO getCarById(Long id);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}
