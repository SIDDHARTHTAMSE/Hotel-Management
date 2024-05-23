package com.jsp.HotelManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dto.Hotel;

@Service
public class Hotelservice {
	
	@Autowired
	private Hoteldao hoteldao;
	
	public Hotel saveHotel(Hotel hotel)
	{
		return hoteldao.saveHotel(hotel);
	}
	
	public Hotel updateHotel(int hid, Hotel hotel)
	{
		 Hotel dbHotel=hoteldao.gethotelbyid(hid);
		 if(dbHotel!=null)
		 {
			 hotel.setHotel_id(hid);
			 return hoteldao.updateHotel(hotel);
		 }
		 else
		 {
			 return null;
		 }
	}
	public Hotel deleteHotel(int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		if(hotel!=null)
		{
			return hoteldao.deleteHotel(hid);
		}
		else
		{
			return null;
		}
	}
	public Hotel getHotelbyid(int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		if(hotel!=null)
		{
			return hotel;
		}
		else
		{
			return null;
		}
	}
}










