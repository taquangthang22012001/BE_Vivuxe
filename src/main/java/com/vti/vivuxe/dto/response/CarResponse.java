package com.vti.vivuxe.dto.response;

import com.vti.vivuxe.entity.Car;
import lombok.Data;

import java.util.Date;

@Data
public class CarResponse {
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

	public CarResponse() {
	}

	public CarResponse(Car car) {
		this.carId = car.getCarId();
		this.name = car.getName();
		this.make = car.getMake().name();
		this.model = car.getModel();
		this.seat = car.getSeat();
		this.year = car.getYear();
		this.address = car.getAddress();
		this.transmission = car.getTransmission().name();
		this.licensePlate = car.getLicensePlate();
		this.fuel = car.getFuel().name();
		this.bluetooth = car.getBluetooth();
		this.camera360 = car.getCamera360();
		this.cost = car.getCost();
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
