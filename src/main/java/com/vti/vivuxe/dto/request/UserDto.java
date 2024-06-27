package com.vti.vivuxe.dto.request;

import com.vti.vivuxe.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private Long userId;
    private String username;
    private String password; // Thêm password nếu cần thiế
    private String email;
    private String phone;
    private Date dob;
    private String driverLicense;
    private String address;
    private Date createDate;
    private Gender gender;
    private List<CarDto> carList;
}
