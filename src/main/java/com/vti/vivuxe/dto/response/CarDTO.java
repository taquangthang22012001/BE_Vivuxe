package com.vti.vivuxe.dto.response;
import com.vti.vivuxe.entity.Car;
import com.vti.vivuxe.entity.Rental;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CarDTO {
    private Long carId;
//    private String ownerName;
//    private String ownerEmail;
//    private String ownerPhone;
//    private String ownerAccountNumber;
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
//    private List<RentalDTO> rentals;


    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.carId = car.getCarId();
        this.name = car.getName();
        this.licensePlate = car.getLicensePlate();
        this.cost = car.getCost();
        this.createDate = car.getCreateDate();
        this.address = car.getAddress();
        this.make = car.getMake().name();
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

        List<RentalDTO> rentalDTOS = new ArrayList<>();

//        for(Rental rental : car.getRentals()){
//            rentalDTOS.add(new RentalDTO(rental));
//        }
//        this.rentals = rentalDTOS;
    }
}
