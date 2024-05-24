package com.jsp.HotelManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Customerdao;
import com.jsp.HotelManagementSystem.dto.Customer;

@Service
public class Customerservice {
	
	@Autowired
	private Customerdao customerdao;
	
	public Customer saveCustomer(Customer customer)
	{
		Customer dbCustomer=customerdao.saveCustomer(customer);
		if(dbCustomer!=null)
		{
			return dbCustomer;
		}
		else
		{
			return null;
		}
	}
	
	public Customer updateCustomer(int cid,Customer customer)
	{
		Customer dbCustomer=customerdao.getCustomerbyid(cid);
		if(dbCustomer!=null)
		{
			customer.setCustomer_id(cid);
			return customerdao.updateCustomer(customer);
		}
		else
		{
			return null;
		}    
	}
	public Customer deleteCustomer(int cid)
	{
		Customer customer=customerdao.getCustomerbyid(cid);
		if(customer!=null)
		{
			return customerdao.deleteCustomer(customer);
		}
		else
		{
			return null;
		}
	}
	public Customer getCustomerbyid(int cid)
	{
		Customer customer=customerdao.getCustomerbyid(cid);
		if(customer!=null)
		{
			return customer;
		}
		else
		{
			return null;
		}
	}
	public Customer getCustomerbyemail(String customer_email)
	{
		Customer customer=customerdao.getCustomerbyrmail(customer_email);
		if(customer!= null)
		{
			return customer;
		}
		else
		{
			return null;
		}
		
	}
	public List<Customer> getallCustomers()
	{
		return customerdao.getallCustomer();
	}
	
	public Customer loginCustomer(String email, String password)
	{
		Customer customer=customerdao.getCustomerbyemail(email);
		if(customer.getCustomer_password().equals(password))
		{
			return customer;
		}
		else
		{
			return null;
		}
	}
	
	
}
