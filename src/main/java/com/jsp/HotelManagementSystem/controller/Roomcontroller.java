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

import com.jsp.HotelManagementSystem.dto.Room;
import com.jsp.HotelManagementSystem.service.Roomservice;

@Controller
@RequestMapping("/room")
public class Roomcontroller {
	
	@Autowired
	private Roomservice roomservice;
	
	@PostMapping
	public Room saveRoom(@RequestBody Room room, @RequestParam int hid)
	{
		return roomservice.saveRoom(room, hid);
	}
	
	@PutMapping
	public Room updateRoom(@RequestParam int rid, @RequestBody Room room)
	{
		return roomservice.updateRoom(rid, room);
	}
	
	@DeleteMapping
	public Room deleteRoom(@RequestParam int rid)
	{
		return roomservice.deleteRoom(rid);
	}
	
	@GetMapping
	public Room getRoombyid(@RequestParam int rid)
	{
		return roomservice.getRoombyid(rid);
	}
	
	@GetMapping("/roombyno")
	public Room getRoomno(@RequestParam int room_no)
	{
		return roomservice.getRoombyid(room_no);
	}
	
	@GetMapping("/roombytype")
	public List<Room> getroombytype(@RequestParam String room_type)
	{
		return roomservice.getRoombytype(room_type);
	}
	
	@GetMapping("/roombyavailability")
	public List<Room> getRoombyavailability(@RequestParam String availability)
	{
		return roomservice.getRoombyavailability(availability);
	}
	
	@GetMapping("/getallrooms")
	public List<Room> getallRooms()
	{
		return roomservice.getallRooms();
	}
	
}
