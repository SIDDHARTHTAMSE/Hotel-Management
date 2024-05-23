package com.jsp.HotelManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.HotelManagementSystem.dto.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer>{
	
	
	@Query("select c from Customer c where c.customer_email=?1")
	public Customer getCustomerbyemail(String customer_email);
	
}
