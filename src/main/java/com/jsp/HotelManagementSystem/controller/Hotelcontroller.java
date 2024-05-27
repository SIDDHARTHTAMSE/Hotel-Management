package com.jsp.HotelManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Hotelservice;

@Controller
@RequestMapping("/hotel")
public class Hotelcontroller {
	
	@Autowired
	private Hotelservice hotelservice;
	
	@PostMapping
	public Hotel saveHotel(@RequestBody Hotel hotel)
	{
		return hotelservice.saveHotel(hotel);
	}
	@PutMapping
	public Hotel updateHotel(@RequestParam int hid, @RequestBody Hotel hotel)
	{
		return hotelservice.updateHotel(hid, hotel);
	}
	
	@DeleteMapping
	public Hotel deleteHotel(@RequestParam int hid)
	{
		return hotelservice.deleteHotel(hid);
	}
	
	@GetMapping
	public Hotel gethotelbyid(@RequestParam int hid)
	{
		return hotelservice.getHotelbyid(hid);
	}
	 
}
