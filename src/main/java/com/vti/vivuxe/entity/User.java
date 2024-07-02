package com.vti.vivuxe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.vivuxe.enums.Gender;
import com.vti.vivuxe.enums.Role;
import jakarta.persistence.*;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dob;

	@Column(name = "driver_license", unique = true)
	private String driverLicense;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rental> rentals;

	@PrePersist
	protected void onCreate() {
		if (this.createDate == null) {
			this.createDate = new Date();
		}

		if (this.role == null){
			this.role = Role.USER;
		}

		if(this.gender == null){
			this.gender = Gender.UNKNOWN;
		}
	}


}
