package com.vti.vivuxe.controller;

import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.entity.User;
import com.vti.vivuxe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<?> getAllUsers(Pageable pageable) {
		return ResponseEntity.ok(userService.getAllUsers(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody @Valid UserCreationRequest request) {
		return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody @Valid UserCreationRequest request) {
		return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
	}
}
