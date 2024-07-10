package com.vti.vivuxe.service.Authentication;

import com.vti.vivuxe.dto.request.SigninRequest;
import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.dto.response.JWTAuthenticationResponse;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.enums.Role;
import com.vti.vivuxe.repository.UserRepository;
import com.vti.vivuxe.service.JWT.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	public User signup(UserCreationRequest signupRequest){
		User user = new User();

		user.setUsername(signupRequest.getUsername());
		user.setEmail(signupRequest.getEmail());
		user.setDriverLicense(signupRequest.getDriverLicense());
		user.setAddress(signupRequest.getAddress());
		user.setGender(signupRequest.getGender());
		user.setDob(signupRequest.getDob());
		user.setPhone(signupRequest.getPhone());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

		return userRepository.save(user);
	}

	public JWTAuthenticationResponse signin(SigninRequest request){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

		var user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

		var jwt = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

		JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();

		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);

		return jwtAuthenticationResponse;
	}

}
