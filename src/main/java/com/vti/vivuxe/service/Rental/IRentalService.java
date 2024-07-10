package com.vti.vivuxe.service.Rental;

import com.vti.vivuxe.dto.request.RentalCreationRequest;
import com.vti.vivuxe.dto.response.RentalDTO;
import com.vti.vivuxe.entity.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRentalService {
	void createRental(RentalCreationRequest request);

	Page<RentalDTO> getAllRentals(Pageable pageable);

	RentalDTO getRentalById(Long id);

	void updateRental(Long id, RentalCreationRequest request);

	void deleteRentalById(Long id);
}
