package com.jsp.HotelManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@NotNull(message = "customer cannot be null")
	@NotBlank(message = "customer name cannot be blank")
	private String customer_name;
	@NotNull(message = "customer address cannot be null")
	@NotBlank(message = "customer address cannot be blank")
	private String customer_address;
	@NotNull(message = "customer email cannot be null")
	@NotBlank(message = "customer email cannot be blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String customer_email;
	@NotNull(message = "customer password email cannot be null")
	@NotBlank(message = "customer password email cannot be blank")
	@Pattern(regexp = "^(?=.[0-9])+(?=.[a-z])+(?=.[A-Z])+(?=.[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 specialCharacter,1 number)")
	private String customer_password;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long customer_phone;
	@NotNull(message = "customer aadhar cannot be null")
	@NotBlank(message = "customer aadhar cannot be blank")
	@Pattern(regexp = "[1-9][1-9]{11}", message = "Invalid Aadhar")//shd give 12 numbers
	private String customer_aadhar;
	
}
