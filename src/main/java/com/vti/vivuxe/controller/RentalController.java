package com.vti.vivuxe.controller;

import com.vti.vivuxe.dto.request.RentalCreationRequest;
import com.vti.vivuxe.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {
	@Autowired
	private RentalService rentalService;

	@GetMapping()
	public ResponseEntity<?> getAllRentals(Pageable pageable){
		return ResponseEntity.ok(rentalService.getAllRentals(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRentalById(@PathVariable Long id){
		return ResponseEntity.ok(rentalService.getRentalById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateRental(@PathVariable Long id, @RequestBody RentalCreationRequest request){
		return ResponseEntity.ok(rentalService.updateRental(id, request));
	}

	@PostMapping()
	public ResponseEntity<?> createRental(@RequestBody RentalCreationRequest request){
		rentalService.createRental(request);
		return new ResponseEntity<>("Create Rental Successfully!", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRental(@PathVariable Long id){
		rentalService.deleteRentalById(id);
		return new ResponseEntity<>("Delete Rental Successfully with id: " + id, HttpStatus.OK);
	}
}
