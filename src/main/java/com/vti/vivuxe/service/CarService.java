package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.admin.CarDTO;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.repository.CarRepository;
import com.vti.vivuxe.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor

public class CarService implements CarServiceImp {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;

    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public List<CarDTO> getAllCars() {

		List<Car> cars = carRepository.findAll();
		return cars.stream()
				.map(car -> modelMapper.map(car, CarDTO.class))
				.collect(Collectors.toList());
	}

	public CarDTO getCarById(Long id) {
		return carRepository.findById(id)
				.map(car -> modelMapper.map(car, CarDTO.class)).orElse(null);
	}

	public CarDTO createCar(CarCreationRequest carCreationRequest) {
		var CarCreate = modelMapper.map(carCreationRequest, Car.class);
		var save = carRepository.save(CarCreate);
		return modelMapper.map(save, CarDTO.class);
	}

	public Car updateCar(Long id, Car car) {
		if (!carRepository.existsById(id)) {
			throw new NoSuchElementException("Car not found with id: " + id);
		} else {
			Car existingCar = carRepository.findById(id).get();

			existingCar.setName(car.getName());
			existingCar.setLicensePlate(car.getLicensePlate());
			// Update other fields as necessary

			return carRepository.save(existingCar);
		}
	}

	public void deleteCar(Long id) {
		carRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Car not found with id: " + id));

		Car car = carRepository.findById(id).get();
		carRepository.delete(car);
	}
}

