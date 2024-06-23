package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.exception.DuplicateFieldException;
import com.vti.vivuxe.repository.UserRepository;
import com.vti.vivuxe.utils.DateValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(UserCreationRequest request) throws DuplicateFieldException {

		if (userRepository.existsByUsername(request.getUsername())) {
			throw new DuplicateFieldException("Username is already existed!");
		} else if (userRepository.existsByDriverLicense(request.getDriverLicense())) {
			throw new DuplicateFieldException("Driver License is already existed");
		} else if (userRepository.existsByEmail(request.getEmail())) {
			throw new DuplicateFieldException("Email is already existed");
		} else if (userRepository.existsByPhone(request.getPhone())) {
			throw new DuplicateFieldException("Phone number is already existed!");
		} else {
			//			validate date format
			if (!DateValidator.valDate(request.getDob())) {
				throw new IllegalArgumentException("Invalid date format!");
			}

//			validate if date is in the past
			if (!DateValidator.valDate(request.getDob())) {
				throw new IllegalArgumentException("Invalid date");
			}

			User user = modelMapper.map(request, User.class);
			return userRepository.save(user);
		}
	}

	public User getUserById(Long id) throws NoSuchElementException {
		return userRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoSuchElementException("User not found with id: " + id);
				});
	}

	public User updateUser(Long id, UserCreationRequest request) {
		if (!userRepository.existsById(id)) {
			throw new NoSuchElementException("User not found with id: " + id);
		} else {

//			validate date format
			if (!DateValidator.valDate(request.getDob())) {
				throw new IllegalArgumentException("Invalid date format!");
			}

			User user = userRepository.findById(id).get();
			modelMapper.map(request, user);

			return userRepository.save(user);
		}
	}

	public void deleteUser(Long id) {
		userRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoSuchElementException("User not found with id: " + id);
				});

		User user = userRepository.findById(id).get();

		userRepository.delete(user);
	}
}
