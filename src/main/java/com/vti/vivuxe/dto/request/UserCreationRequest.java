package com.vti.vivuxe.dto.request;

import com.vti.vivuxe.enums.Gender;
import com.vti.vivuxe.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserCreationRequest {
	@NotNull(message = "Username cannot be null")
	@Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
	private String username;

	@NotNull(message = "Password cannot be null")
	@Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters")
	private String password;

	@Email(message = "invalid email")
	private String email;

	@NotNull(message = "Phone number cannot be null")
	@Size(min = 10, max = 11, message = "Phone number must be between 10 and 20 numbers")
	private String phone;

	private String dob;

	@NotNull(message = "Driver License cannot be null")
	@Size(min = 5, max = 15, message = "Driver License must be between 5 and 15 characters")
	private String driverLicense;

	private String address;

	private Gender gender;

	private Role role;
}
