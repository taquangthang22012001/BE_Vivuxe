package com.vti.vivuxe.service;

import com.vti.vivuxe.Form.CarCreate;
import com.vti.vivuxe.dto.request.CarDto;

import java.util.List;

public interface CarSeverInter {
    CarDto createCar(CarCreate carCreate);
    List<CarDto> getAllCars();
    CarDto getCarById(Long id);
}
