package com.vti.vivuxe.entity;

import com.vti.vivuxe.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String phone;

	@Temporal(TemporalType.DATE)
	private String dob;

	@Column(name = "driver_license", unique = true)
	private String driverLicense;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@PrePersist
	protected void onCreate() {
		if(this.createDate == null){
			this.createDate = new Date();
		}
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Car> carList;

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", dob=" + dob +
				", driverLicense='" + driverLicense + '\'' +
				", address='" + address + '\'' +
				", createDate=" + createDate +
				", gender=" + gender +
				", carList=" + carList +
				'}';
	}
}
