package com.vti.vivuxe.dto.request;

import com.vti.vivuxe.entity.Rental;
import com.vti.vivuxe.enums.Fuel;
import com.vti.vivuxe.enums.Status;
import com.vti.vivuxe.enums.Transmission;
import lombok.Data;

import java.util.Date;
@Data
public class CarCreationRequest {
    private String name;
//    private String ownerName;
//    private String ownerEmail;
//    private String ownerPhone;
//    private String ownerAccountNumber;
    private String licensePlate;
    private double cost;
    private String address;
    private String make;
    private String model;
    private int seat;
    private int year;
    private Transmission transmission;
    private Fuel fuel;
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
    private Status status;
    private String description;
}
