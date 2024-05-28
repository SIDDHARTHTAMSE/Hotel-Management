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

import com.jsp.HotelManagementSystem.dto.Room;
import com.jsp.HotelManagementSystem.service.Roomservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Controller
@RequestMapping("/room")
public class Roomcontroller {
	
	@Autowired
	private Roomservice roomservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Room>> saveRoom(@RequestBody Room room, @RequestParam int hid)
	{
		return roomservice.saveRoom(room, hid);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Room>> updateRoom(@RequestParam int rid, @RequestBody Room room)
	{
		return roomservice.updateRoom(rid, room);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Room>> deleteRoom(@RequestParam int rid)
	{
		return roomservice.deleteRoom(rid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Room>> getRoombyid(@RequestParam int rid)
	{
		return roomservice.getRoombyid(rid);
	}
	
	@GetMapping("/roombyno")
	public ResponseEntity<Responsestructure<Room>> getRoomno(@RequestParam String room_no)
	{
		return roomservice.getRoombyno(room_no);
	}
	
	@GetMapping("/roombytype")
	public ResponseEntity<Responsestructure<List<Room>>> getroombytype(@RequestParam String room_type)
	{
		return roomservice.getRoombytype(room_type);
	}
	
	@GetMapping("/roombyavailability")
	public ResponseEntity<Responsestructure<List<Room>>> getRoombyavailability(@RequestParam String availability)
	{
		return roomservice.getRoombyavailability(availability);
	}
	
	@GetMapping("/getallrooms")
	public ResponseEntity<Responsestructure<List<Room>>> getallRooms()
	{
		return roomservice.getallRooms();
	}
	
}
