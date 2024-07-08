package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.CarDTO;
import com.vti.vivuxe.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarServiceImp {
    Page<CarDTO> getAllCars(Pageable pageable);
    void createCar(CarCreationRequest carCreationRequest);
    CarDTO getCarById(Long id);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}
