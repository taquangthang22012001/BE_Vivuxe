package com.vti.vivuxe.dto.response.admin;

import lombok.Data;

import java.util.Date;

@Data
public class RentalDTO {
	private Long rentalId;
	private Date rentalDate;
	private Date rentalReturn;
	private String status;
	private Long userUserId;
	private Long carCarId;
}
