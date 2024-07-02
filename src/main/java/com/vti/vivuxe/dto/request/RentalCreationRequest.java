package com.vti.vivuxe.dto.request;
import com.vti.vivuxe.enums.Status;

import lombok.Data;

import java.util.Date;

@Data
public class RentalCreationRequest {
    private Long userUserId;
    private Long carCarId;
    private Date rentalDate;
    private Date rentalReturn;
    private Status status;
}
