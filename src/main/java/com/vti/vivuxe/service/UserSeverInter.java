package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.UserDto;

import java.util.List;

public interface UserSeverInter {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
}
