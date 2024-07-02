package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.RentalCreationRequest;
import com.vti.vivuxe.dto.response.admin.RentalDTO;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.entity.Rental;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.repository.CarRepository;
import com.vti.vivuxe.repository.RentalRepository;
import com.vti.vivuxe.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@NoArgsConstructor
public class RentalService implements RentalServiceImp {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private UserRepository userRepository;

	public RentalService(RentalRepository rentalRepository, CarRepository carRepository, UserRepository userRepository) {
		this.rentalRepository = rentalRepository;
		this.carRepository = carRepository;
		this.userRepository = userRepository;
	}


	public RentalDTO createRental(RentalCreationRequest request) {


		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		Car car = carRepository.findById(request.getCarId())
				.orElseThrow(() -> new RuntimeException("Car not found"));
		Rental rental = modelMapper.map(request, Rental.class);
		rental.setUser(user);
		rental.setCar(car);
		// Lưu Rental vào cơ sở dữ liệu
		Rental savedRental = rentalRepository.save(rental);

		// Ánh xạ và trả về DTO của Rental đã lưu
		return  modelMapper.map(savedRental,RentalDTO.class);
	}

	public Page<RentalDTO> getAllRentals(Pageable pageable) {
		Page<Rental> rentalList = rentalRepository.findAll(pageable);

		Page<RentalDTO> rentalDTOS = rentalList.map(rental -> modelMapper.map(rental, RentalDTO.class));

		return rentalDTOS;
	}

	public RentalDTO getRentalById(Long id) {
		return rentalRepository.findById(id)
				.map(rental -> modelMapper.map(rental, RentalDTO.class)).orElse(null);
	}


	public Rental updateRental(Long id, RentalCreationRequest request) {
		Optional<Rental> optionalRental = rentalRepository.findById(id);

		if (optionalRental.isEmpty()) {
			throw new RuntimeException("Rental not found with id: " + id);
		}

		Rental existingRental = optionalRental.get();

		modelMapper.map(request, existingRental);

		return rentalRepository.save(existingRental);
	}


	public void deleteRentalById(Long id) {
		rentalRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Rental not found with id: " + id));

		Rental rental = rentalRepository.findById(id).get();
		rentalRepository.delete(rental);
	}


}
