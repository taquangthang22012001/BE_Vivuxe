package com.vti.vivuxe.entity;

import com.vti.vivuxe.enums.Fuel;
import com.vti.vivuxe.enums.Status;
import com.vti.vivuxe.enums.Transmission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
	private Date createDate;

	private String address;

	private String make;

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

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
	private User user;

	@Override
	public String toString() {
		return "Car{" +
				"carId=" + carId +
				", name='" + name + '\'' +
				", licensePlate='" + licensePlate + '\'' +
				", cost=" + cost +
				", createDate=" + createDate +
				", address='" + address + '\'' +
				", make='" + make + '\'' +
				", model='" + model + '\'' +
				", seat=" + seat +
				", year=" + year +
				", transmission=" + transmission +
				", fuel=" + fuel +
				", bluetooth=" + bluetooth +
				", camera360=" + camera360 +
				", sideCamera=" + sideCamera +
				", dashCamera=" + dashCamera +
				", rearCamera=" + rearCamera +
				", gps=" + gps +
				", childSeat=" + childSeat +
				", usb=" + usb +
				", spareTire=" + spareTire +
				", dvdScreen=" + dvdScreen +
				", etc=" + etc +
				", airbags=" + airbags +
				", status=" + status +
				", description='" + description + '\'' +
				", user=" + user +
				'}';
	}
}
