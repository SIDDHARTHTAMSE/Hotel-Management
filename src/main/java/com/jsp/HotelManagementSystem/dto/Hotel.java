package com.jsp.HotelManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	@NotNull(message = "hotel name cannot be null")
	@NotBlank(message = "hotel name cannot be blank")
	private String hotel_name;
	@NotNull(message = "hotel gst cannot be null")
	@NotBlank(message = "hotel gst cannot be blank")
	private String hotel_gst;
	@NotNull(message = "hotel address cannot be null")
	@NotBlank(message = "hotel address cannot be blank")
	private String hotel_address;
	@NotNull(message = "hotel manager cannot be null")
	@NotBlank(message = "hotel manager cannot be blank")
	private String hotel_manager;
	@NotNull(message = "hotel owner cannot be null")
	@NotBlank(message = "hotel owner cannot be blank")
	private String hotel_owner;
	private int hotel_rating;
}
