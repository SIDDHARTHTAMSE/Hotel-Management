package com.jsp.HotelManagementSystem.service;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dao.Roomdao;
import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.dto.Room;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Service
public class Roomservice {
	
	@Autowired
	private Roomdao roomdao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	Responsestructure<Room> responsestructure = new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Room>> saveRoom(Room room, int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		room.setHotel(hotel);
		Room room2=roomdao.saveRoom(room);
		if(room2!=null)
		{
			responsestructure.setMessage("save successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(room2);
			return new ResponseEntity<Responsestructure<Room>>(responsestructure, HttpStatus.CREATED);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Room>> updateRoom(int rid, Room room)
	{
		Room dbRoom=roomdao.getRoombyid(rid);
		if(dbRoom!=null)
		{
			room.setRoom_id(rid);
			room.setHotel(dbRoom.getHotel());
			responsestructure.setMessage("updated successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(roomdao.updateRoom(room));
			return new ResponseEntity<Responsestructure<Room>>(responsestructure, HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Room>> deleteRoom(int rid)
	{
		Room room=roomdao.getRoombyid(rid);
		if(room!=null)
		{
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(roomdao.deleteRoom(room));
			return new ResponseEntity<Responsestructure<Room>>(responsestructure, HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Room>> getRoombyid(int rid)
	{
		Room room=roomdao.getRoombyid(rid);
		if(room!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(room);
			return new ResponseEntity<Responsestructure<Room>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<List<Room>>> getRoombytype(String room_type)
	{
		List<Room> rooms=roomdao.getRoombytype(room_type);
		if(rooms!=null)
		{
			Responsestructure<List<Room>> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(rooms);
			return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Room>> getRoombyno(int room_no)
	{
		Room room=roomdao.getRoombyno(room_no);
		if(room!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(room);
			return new ResponseEntity<Responsestructure<Room>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<List<Room>>> getRoombyavailability(String availability)
	{
		List<Room> list=roomdao.getRoombyavailability(availability);
		if(list!=null)
		{
			Responsestructure<List<Room>> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(list);
			return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	
	
	public ResponseEntity<Responsestructure<List<Room>>> getallRooms()
	{
		Responsestructure<List<Room>> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("found successfully");
		responsestructure.setStatus(HttpStatus.FOUND.value());
		responsestructure.setData(roomdao.getallRooms());
		return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure, HttpStatus.FOUND);
	}
	  
}
