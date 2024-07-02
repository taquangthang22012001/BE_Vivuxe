package com.vti.vivuxe.dto.response.admin;
import com.vti.vivuxe.enums.Fuel;
import com.vti.vivuxe.enums.Status;
import com.vti.vivuxe.enums.Transmission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CarDTO {
    private Long carId;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String ownerAccountNumber;
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
    private Long rentalRentalId;
    private Date rentalRentalDate;
    private Date rentalRentalReturn;
    private String rentalStatus;
}
