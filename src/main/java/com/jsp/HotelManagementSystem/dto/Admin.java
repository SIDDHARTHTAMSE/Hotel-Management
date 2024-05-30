package com.jsp.HotelManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	@NotBlank(message = "admin name cannot be blank")
	@NotNull(message = "admin name cannot be null")
	private String admin_name;
	@NotNull(message = "admin email cannot be null")
	@NotBlank(message = "admin email cannot be blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String admin_email;
	@NotNull(message = "admin password email cannot be null")
	@NotBlank(message = "admin password email cannot be blank")
	@Pattern(regexp = "^(?=.[0-9])+(?=.[a-z])+(?=.[A-Z])+(?=.[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 specialCharacter,1 number)")
	private String admin_password;
	
	@OneToOne
	private Hotel hotel;
}
