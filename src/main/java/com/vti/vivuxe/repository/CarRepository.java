package com.vti.vivuxe.repository;

import com.vti.vivuxe.Form.CarCreate;
import com.vti.vivuxe.dto.request.CarDto;
import com.vti.vivuxe.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    boolean existsByLicensePlate(String licensePlate);

}

