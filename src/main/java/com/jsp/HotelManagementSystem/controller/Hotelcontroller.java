package com.jsp.HotelManagementSystem.controller;

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

import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Hotelservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Controller
@RequestMapping("/hotel")
public class Hotelcontroller {
	
	@Autowired
	private Hotelservice hotelservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(@RequestBody Hotel hotel)
	{
		return hotelservice.saveHotel(hotel);
	}
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(@RequestParam int hid, @RequestBody Hotel hotel)
	{
		return hotelservice.updateHotel(hid, hotel);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(@RequestParam int hid)
	{
		return hotelservice.deleteHotel(hid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(@RequestParam int hid)
	{
		return hotelservice.getHotelbyid(hid);
	}
	 
}
