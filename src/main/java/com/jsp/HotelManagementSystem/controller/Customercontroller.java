package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.HotelManagementSystem.dto.Customer;
import com.jsp.HotelManagementSystem.service.Customerservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Controller
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	private Customerservice customerservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Customer>> saveCustomer(@RequestBody Customer customer)
	{
		return customerservice.saveCustomer(customer);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Customer>> updateCustomer(@RequestParam int cid, @RequestBody Customer customer)
	{
		return customerservice.updateCustomer(cid, customer);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Customer>> deleteCustomer(@RequestParam int cid)
	{
		return customerservice.deleteCustomer(cid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyid(@RequestParam int cid)
	{
		return customerservice.getCustomerbyid(cid);
	}
	
	@GetMapping("/customerbyemail")
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyemail(@RequestParam String customer_email)
	{
		return customerservice.getCustomerbyemail(customer_email);
	}
	
	@GetMapping("/getallcustomers")
	public ResponseEntity<Responsestructure<List<Customer>>> getallcustomer()
	{
		return customerservice.getallCustomers();
	}
	
	@GetMapping("/customerlogin ")
	public ResponseEntity<Responsestructure<Customer>> loginCustomer(@RequestParam String email, @RequestParam String password)
	{
		return customerservice.loginCustomer(email, password);
	}
		
}
