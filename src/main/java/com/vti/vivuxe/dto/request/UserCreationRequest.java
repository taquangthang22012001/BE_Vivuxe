package com.vti.vivuxe.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.vivuxe.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class UserCreationRequest {
	@NotNull(message = "Username cannot be null")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String username;

	@NotNull(message = "Password cannot be null")
	@Size(min = 5, message = "Password must be at least 5 characters")
	private String password;

	@Email(message = "invalid email")
	private String email;

	private String phone;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String dob;

	@NotNull(message = "Driver License cannot be null")
	@Size(min = 5, message = "Driver License must be at least 5 characters")
	private String driverLicense;

	private String address;

	private Gender gender;

	@Override
	public String toString() {
		return "UserCreationRequest{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", dob=" + dob +
				", driverLicense='" + driverLicense + '\'' +
				", gender=" + gender +
				'}';
	}
}
