package com.vti.vivuxe.entity;

import com.vti.vivuxe.enums.Fuel;
import com.vti.vivuxe.enums.Make;
import com.vti.vivuxe.enums.Status;
import com.vti.vivuxe.enums.Transmission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long carId;

	private String name;

	@Column(name = "license_plate", unique = true, nullable = false)
	private String licensePlate;

	private double cost = 0.0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	private String address;

	private Make make;

	private String model;

	private int seat;

	private int year;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Transmission transmission;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Fuel fuel;

	private Boolean bluetooth;

	@Column(name = "camera_360")
	private Boolean camera360;

	@Column(name = "side_camera")
	private Boolean sideCamera;

	@Column(name = "dash_camera")
	private Boolean dashCamera;

	@Column(name = "rear_camera")
	private Boolean rearCamera;

	private Boolean gps;

	@Column(name = "child_seat")
	private Boolean childSeat;

	private Boolean usb;

	@Column(name = "spare_tire")
	private Boolean spareTire;

	@Column(name = "dvd_screen")
	private Boolean dvdScreen;

	private Boolean etc;

	private Boolean airbags;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;

	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
	private List<Rental> rentals;

	@PrePersist
	protected void onCreate(){
		if(this.createDate == null){
			this.createDate = new Date();
		}
	}
}
