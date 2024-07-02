package com.vti.vivuxe.dto.request;
import com.vti.vivuxe.enums.Status;

import lombok.Data;

import java.util.Date;

@Data
public class RentalCreationRequest {
    private Long userId;
    private Long carId;
    private Date rentalDate;
    private Date rentalReturn;
    private Status status;
}
