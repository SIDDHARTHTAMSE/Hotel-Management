package com.jsp.HotelManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.HotelManagementSystem.service.Bookingservice;

@Controller
@RequestMapping("/Booking")
public class Bookingcontroller {
	
	@Autowired
	private Bookingservice bookingservice;
	
	
}
