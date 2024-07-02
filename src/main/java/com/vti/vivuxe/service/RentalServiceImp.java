package com.vti.vivuxe.service;

import com.vti.vivuxe.dto.request.RentalCreationRequest;
import com.vti.vivuxe.dto.response.admin.RentalDTO;
import com.vti.vivuxe.entity.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentalServiceImp {
	RentalDTO createRental(RentalCreationRequest request);
	Page<RentalDTO> getAllRentals(Pageable pageable);
	RentalDTO getRentalById(Long id);
	Rental updateRental(Long id, RentalCreationRequest request);
	void deleteRentalById(Long id);
}
