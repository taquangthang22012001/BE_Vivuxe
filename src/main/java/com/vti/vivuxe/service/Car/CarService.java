package com.vti.vivuxe.service.Car;

import com.vti.vivuxe.dto.request.CarCreationRequest;
import com.vti.vivuxe.dto.response.CarDTO;
import com.vti.vivuxe.dto.response.UserResponse;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.repository.CarRepository;
import com.vti.vivuxe.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
@NoArgsConstructor

public class CarService implements ICarService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;

	public Page<CarDTO> getAllCars(Pageable pageable) {

		Page<Car> cars = carRepository.findAll(pageable);

		Page<CarDTO> carDTOS = cars.map(new Function<Car, CarDTO>() {
			@Override
			public CarDTO apply(Car entity) {
				CarDTO dto = new CarDTO(entity);
				return dto;
			}
		});
		return carDTOS;
	}

	public CarDTO getCarById(Long id) {
		Optional<Car> optionalCar = carRepository.findById(id);

		if(optionalCar.isEmpty()){
			throw new RuntimeException("Car not found with id: " + id);
		}

		Car existingCar = optionalCar.get();

		CarDTO carDTO = modelMapper.map(existingCar, CarDTO.class);


		return carDTO;
	}

	public void createCar(CarCreationRequest request) {
		Car car = modelMapper.map(request, Car.class);

		User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (Objects.isNull(u))
			new RuntimeException("User not found");

//		Get user by id for setUser

		User user = userRepository.findById(u.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		car.setUser(user);

		carRepository.save(car);
	}

	public void updateCar(Long id, CarCreationRequest request) {
		Optional<Car> optionalCar = carRepository.findById(id);

		if (optionalCar.isEmpty()) {
			throw new NoSuchElementException("Car not found with id: " + id);
		} else {
			Car existingCar = optionalCar.get();

			modelMapper.map(request, existingCar);

			carRepository.save(existingCar);
		}
	}

	public void deleteCar(Long id) {
		carRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Car not found with id: " + id));

		Car car = carRepository.findById(id).get();
		carRepository.delete(car);
	}
}

