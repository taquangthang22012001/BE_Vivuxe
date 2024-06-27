package com.vti.vivuxe.service;

import com.vti.vivuxe.Form.CarCreate;
import com.vti.vivuxe.dto.request.CarDto;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.exception.DuplicateFieldException;
import com.vti.vivuxe.repository.CarRepository;
import com.vti.vivuxe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService implements CarSeverInter {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<CarDto> getAllCars(){

        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    public CarDto getCarById(Long id)  {
        return carRepository.findById(id)
                .map(car -> modelMapper.map(car,CarDto.class)).orElse(null);
    }

    public CarDto createCar(CarCreate carCreate)  {
       var CarCreate = modelMapper.map(carCreate,Car.class);
       var save= carRepository.save(CarCreate);
        return  modelMapper.map(save,CarDto.class);
    }
    public Car updateCar(Long id, Car car) {
        if (!carRepository.existsById(id)) {
            throw new NoSuchElementException("Car not found with id: " + id);
        } else {
            Car existingCar = carRepository.findById(id).get();

            User user = userRepository.findById(car.getUser().getUserId())
                    .orElseThrow(() -> new NoSuchElementException("User not found with id: " + car.getUser().getUserId()));

            existingCar.setUser(user);
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

