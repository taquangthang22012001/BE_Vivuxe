package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.UserCreationRequest;
import com.vti.vivuxe.dto.response.admin.UserDTO;
import com.vti.vivuxe.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface UserServiceImp {
	Page<UserDTO> getAllUsers(Pageable pageable);
	UserDTO getUserById(Long id);
	User createUser(UserCreationRequest request);
	User updateUser(Long id, UserCreationRequest request);
	void deleteUser(Long id);
}
