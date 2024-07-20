package com.vti.vivuxe.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CarImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "car_image_path")
	private String carImagePath;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "car_id", nullable = false, referencedColumnName = "car_id")
//	private Car car;
}
