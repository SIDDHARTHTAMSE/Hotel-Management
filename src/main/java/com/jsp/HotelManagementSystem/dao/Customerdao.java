package com.jsp.HotelManagementSystem.dao;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HotelManagementSystem.dto.Customer;
import com.jsp.HotelManagementSystem.repo.Customerrepo;

@Repository
public class Customerdao {
	
	@Autowired
	private Customerrepo customerrepo;
	
	public Customer saveCustomer(Customer customer) 
	{
		return customerrepo.save(customer);
	}
	
	public Customer updateCustomer(Customer customer)
	{
		return customerrepo.save(customer);
	}
	
	public Customer deleteCustomer(Customer customer)
	{
		customerrepo.delete(customer);
		return customer;
	}
	
	public Customer getCustomerbyid(int cid)
	{
		if(customerrepo.findById(cid).isPresent())
		{
			return customerrepo.findById(cid).get();
		}
		return null;
	}
	
	public Customer getCustomerbyemail(String customer_email)
	{
		if(customerrepo.getCustomerbyemail(customer_email)!=null)
		{
			return customerrepo.getCustomerbyemail(customer_email);
		}
		return null;
	}
	
	public List<Customer> getallCustomer()
	{
		return customerrepo.findAll();
	}
	
}
