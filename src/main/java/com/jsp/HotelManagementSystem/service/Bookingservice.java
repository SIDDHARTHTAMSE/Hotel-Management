package com.jsp.HotelManagementSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Bookingdao;
import com.jsp.HotelManagementSystem.dao.Customerdao;
import com.jsp.HotelManagementSystem.dao.Roomdao;
import com.jsp.HotelManagementSystem.dto.Booking;
import com.jsp.HotelManagementSystem.dto.Customer;
import com.jsp.HotelManagementSystem.dto.Room;

@Service
public class Bookingservice {
	
	@Autowired
	private Bookingdao bookingdao;
	
	@Autowired
	private Customerdao customerdao;
	
	@Autowired
	private Roomdao roomdao;
	
	public Booking saveBooking(Booking booking, int cid, int rid)
	{
		Room room=roomdao.getRoombyid(rid);
		room.setAvailability("N");
		if(booking.getNo_people()<=room.getMax_people())
		{
			Room room2=roomdao.updateRoom(room);
			Customer customer=customerdao.getCustomerbyid(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime check_in_dateDateTime=LocalDateTime.now();
			booking.setCheck_in_date(check_in_dateDateTime);
			return bookingdao.saveBooking(booking);
		}
		else
		{
			return null;
		}
	}
	
	public Booking updateBooking(Booking booking, int bid)
	{
		Booking dbbooking = bookingdao.getBookingbyid(bid);
		if(dbbooking!=null)
		{
			if(booking.getNo_people()<=dbbooking.getRoom().getMax_people())
			{
				booking.setId(bid);
				booking.setCustomer(dbbooking.getCustomer());
				booking.setRoom(dbbooking.getRoom());
				booking.setCheck_in_date(dbbooking.getCheck_in_date());
				booking.setCheck_out_date(dbbooking.getCheck_out_date());
				return bookingdao.updateBooking(booking);
			}
			return null;
		}
		return null;
	}
	
	public Booking deleteBooking(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		{
			if(booking!=null)
			{
				return bookingdao.deleteBooking(booking);
			}
			else
			{
				return null;
			}
		}
		
	}
	public Booking getBookingbyid(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			return booking;
		}
		else
		{
			return null;
		}
	}
	
	public List<Booking> getallBookings()
	{
		return bookingdao.getallBookings();
	}
	
	public Booking CloseBooking(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			LocalDateTime check_out_date = LocalDateTime.now();
			booking.setCheck_out_date(check_out_date);
			Room room=booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			return bookingdao.updateBooking(booking);
		}
		else
		{
			return null;
		}
	}
	
	
	

}
