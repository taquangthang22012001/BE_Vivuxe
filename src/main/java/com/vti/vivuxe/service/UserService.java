package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.dto.response.admin.UserDTO;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Page<UserDTO> getAllUsers(Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);

		Page<UserDTO> userDTOS = users.map(user -> modelMapper.map(user, UserDTO.class));

		return userDTOS;
	}

	public User createUser(UserCreationRequest request) {
		Boolean existingUser = userRepository.existsByUsername(request.getUsername());

		if (existingUser) {
			throw new RuntimeException("Username is already existed!");
		}

		User user = modelMapper.map(request, User.class);
		return userRepository.save(user);
	}

	public UserDTO getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isEmpty()) {
			throw new RuntimeException("User not found with id: " + id);
		}

		return userRepository.findById(id)
				.map(user -> modelMapper.map(user, UserDTO.class)).orElse(null);
	}

	public User updateUser(Long id, UserCreationRequest request) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found with " + id));

		modelMapper.map(request, user);

		return userRepository.save(user);
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
