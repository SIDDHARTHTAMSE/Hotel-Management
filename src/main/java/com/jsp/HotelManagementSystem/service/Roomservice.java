package com.jsp.HotelManagementSystem.service;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dao.Roomdao;
import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.dto.Room;

@Service
public class Roomservice {
	
	@Autowired
	private Roomdao roomdao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	public Room saveRoom(Room room, int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		room.setHotel(hotel);
		Room room2=roomdao.saveRoom(room);
		if(room2!=null)
		{
			return room2;
		}
		else
		{
			return null;
		}
	}
	public Room updateRoom(int rid, Room room)
	{
		Room dbRoom=roomdao.getRoombyid(rid);
		if(dbRoom!=null)
		{
			room.setRoom_id(rid);
			room.setHotel(dbRoom.getHotel());
			return roomdao.updateRoom(dbRoom);
		}
		else
		{
			return null;
		}
	}
	public Room deleteRoom(int rid)
	{
		Room room=roomdao.getRoombyid(rid);
		if(room!=null)
		{
			return roomdao.deleteRoom(room);
		}
		else
		{
			return null;
		}
	}
	public Room getRoombyid(int rid)
	{
		Room room=roomdao.getRoombyid(rid);
		{
			if(room!=null)
			{
				return room;
			}
			else
			{
				return null;
			}
		}
	}
	public List<Room> getRoombytype(String room_type)
	{
		List<Room> rooms=roomdao.getRoombytype(room_type);
		if(rooms!=null)
		{
			return rooms;
		}
		else
		{
			return null;
		}
	}
	public Room getRoombyno(int room_no)
	{
		Room room=roomdao.getRoombyno(room_no);
		if(room!=null)
		{
			return room;
		}
		else
		{
			return null;
		}
	}
	public List<Room> getRoombyavailability(String availability)
	{
		List<Room> list=roomdao.getRoombyavailability(availability);
		if(list!=null)
		{
			return list;
		}
		else
		{
			return null;
		}
	}
	
	
	public List<Room> getallRooms()
	{
		return roomdao.getallRooms();
	}
	  
}
