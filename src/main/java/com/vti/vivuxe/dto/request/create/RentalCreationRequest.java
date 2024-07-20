package com.vti.vivuxe.dto.request.create;
import com.vti.vivuxe.entity.Rental;
import com.vti.vivuxe.enums.Status;

import lombok.Data;

import java.util.Date;

@Data
public class RentalCreationRequest {
//    private Long userId;
    private Long carId;
    private Date rentalDate;
    private Date rentalReturn;
    private String status;

    public Rental asRental() {
        Rental rental = new Rental();
        rental.setRentalDate(this.rentalDate);
        rental.setRentalReturn(this.rentalReturn);
        rental.setStatus(Status.valueOf(this.status));
        return rental;
    }
}
