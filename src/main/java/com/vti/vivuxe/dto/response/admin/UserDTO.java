package com.vti.vivuxe.dto.response.admin;

import com.vti.vivuxe.enums.Gender;
import com.vti.vivuxe.enums.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private Date dob;
    private String driverLicense;
    private String address;
    private Date createDate;
    private Gender gender;
    private Role role;

}
