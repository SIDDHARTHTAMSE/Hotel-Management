package com.jsp.HotelManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;

@Entity
@Data
public class Room {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	@NotNull(message = "room no cannot be null")
	@NotBlank(message = "room no cannot be blank")
	private String room_no;
	@NotNull(message = "room type cannot be null")
	@NotBlank(message = "room type cannot be blank")
	private String room_type;
	@NotNull(message = "room price cannot be null")
	@NotBlank(message = "room price cannot be blank")
	private String room_price;
	@Min(value = 1, message = "beds cannot be less than 1")
	@Max(value = 10, message = "beds cannot be more than 10")
	private int no_beds;
	@Min(value = 1)
	@Max(value = 1)
	private int max_people;
	@NotNull(message = "availability cannot be null")
	@NotBlank(message = "availability cannot be blank")
	@Pattern(regexp = "[Y,N]")
	private String availability;
	
	@Enumerated(EnumType.STRING)
	private Floor floor;
	
	@ManyToOne
	private Hotel hotel;
}
