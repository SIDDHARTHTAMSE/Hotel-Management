package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.HotelManagementSystem.dto.Booking;
import com.jsp.HotelManagementSystem.service.Bookingservice;

@Controller
@RequestMapping("/Booking")
public class Bookingcontroller {
	
	@Autowired
	private Bookingservice bookingservice;
	
	@PostMapping
	public Booking saveBooking(@RequestBody Booking booking, @RequestParam int cid, @RequestParam int rid)
	{
		return bookingservice.saveBooking(booking, cid, rid);
	}
	
	@PutMapping
	public Booking updateBooking(@RequestBody Booking booking, @RequestParam int bid)
	{
		return bookingservice.updateBooking(booking, bid);
	}
	
	@DeleteMapping
	public Booking deleteBooking(@RequestParam int bid)
	{
		return bookingservice.deleteBooking(bid);
	}
	
	@GetMapping("/bookingbyid")
	public Booking getBookingbyid(@RequestParam int bid)
	{
		return bookingservice.getBookingbyid(bid);
	}
	
	@GetMapping("/getallbooking")
	public List<Booking> getallBooking()
	{
		return bookingservice.getallBookings();
	}
	
	@PutMapping("/closebooking")
	public Booking closeBooking(@RequestParam int bid)
	{
		return bookingservice.CloseBooking(bid);
	} 
	
}
