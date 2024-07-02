package com.vti.vivuxe.repository;
import com.vti.vivuxe.entity.Rental;
import com.vti.vivuxe.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{

}
