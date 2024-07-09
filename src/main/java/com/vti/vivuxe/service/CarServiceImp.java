package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarServiceImp {
	Page<CarDTO> getAllCars(Pageable pageable);

	void createCar(CarCreationRequest carCreationRequest);

	CarDTO getCarById(Long id);

	void updateCar(Long id, CarCreationRequest request);

	void deleteCar(Long id);
}
