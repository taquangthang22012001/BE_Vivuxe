package com.vti.vivuxe.dto.response;

import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.entity.Rental;
import com.vti.vivuxe.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class RentalDTO {
	private Long rentalId;
	private Date rentalDate;
	private Date rentalReturn;
	private String status;
	private UserResponse userResponse;
	private CarResponse carResponse;


	//    Tạo constructor để xuất ra giá trị
	public RentalDTO(Rental rental) {
		this.rentalId = rental.getRentalId();
		this.rentalDate = rental.getRentalDate();
		this.rentalReturn = rental.getRentalReturn();
		this.status = rental.getStatus().name();
		this.userResponse = new UserResponse(rental.getUser());
		this.carResponse = new CarResponse(rental.getCar());
	}

	@Data
	public class UserResponse {
		private Long userId;
		private String username;
		private String email;
		private String phone;
		private Date dob;
		private String driverLicense;
		private String address;
		private Date createDate;
		private String gender;
		private String role;

		public UserResponse(User user) {
			this.userId = user.getUserId();
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.phone = user.getPhone();
			this.dob = user.getDob();
			this.driverLicense = user.getDriverLicense();
			this.address = user.getAddress();
			this.createDate = user.getCreateDate();
			this.gender = user.getGender().name();
			this.role = user.getRole().name();
		}
	}

	@Data
	private class CarResponse {
		private Long carId;
		private String name;
		private String licensePlate;
		private double cost;
		private Date createDate;
		private String address;
		private String make;
		private String model;
		private int seat;
		private int year;
		private String transmission;
		private String fuel;
		private Boolean bluetooth;
		private Boolean camera360;
		private Boolean sideCamera;
		private Boolean dashCamera;
		private Boolean rearCamera;
		private Boolean gps;
		private Boolean childSeat;
		private Boolean usb;
		private Boolean spareTire;
		private Boolean dvdScreen;
		private Boolean etc;
		private Boolean airbags;
		private String status;
		private String description;


		public CarResponse(Car car) {
			this.carId = car.getCarId();
			this.name = car.getName();
			this.make = car.getMake();
			this.model = car.getModel();
			this.seat = car.getSeat();
			this.year = car.getYear();
			this.transmission = car.getTransmission().name();
			this.fuel = car.getFuel().name();
			this.bluetooth = car.getBluetooth();
			this.camera360 = car.getCamera360();
			this.sideCamera = car.getSideCamera();
			this.dashCamera = car.getDashCamera();
			this.rearCamera = car.getRearCamera();
			this.gps = car.getGps();
			this.childSeat = car.getChildSeat();
			this.usb = car.getUsb();
			this.spareTire = car.getSpareTire();
			this.dvdScreen = car.getDvdScreen();
			this.etc = car.getEtc();
			this.airbags = car.getAirbags();
			this.status = car.getStatus().name();
			this.description = car.getDescription();
		}
	}
}
