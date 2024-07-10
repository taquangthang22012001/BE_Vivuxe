package com.vti.vivuxe.service.User;

import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.dto.response.UserDTO;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.repository.UserRepository;
import com.vti.vivuxe.service.User.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	public Page<UserDTO> getAllUsers(Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);

		Page<UserDTO> userDTOS = users.map(new Function<User, UserDTO>() {
			@Override
			public UserDTO apply(User entity) {
				UserDTO dto = new UserDTO(entity);
				return dto;
			}
		});

		return userDTOS;
	}

	public void createUser(UserCreationRequest request) {
		Boolean existingUser = userRepository.existsByUsername(request.getUsername());

		if (existingUser) {
			throw new RuntimeException("Username is already existed!");
		}

		User user = modelMapper.map(request, User.class);
		userRepository.save(user);
	}

	public UserDTO getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isEmpty()) {
			throw new RuntimeException("User not found with id: " + id);
		}

		User existingUser = optionalUser.get();

		return modelMapper.map(existingUser, UserDTO.class);
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

	@Override
	public UserDetailsService userDetailsService() {
		return customUserDetailsService;
	}


}
