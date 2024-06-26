package com.jsp.HotelManagementSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Bookingdao;
import com.jsp.HotelManagementSystem.dao.Customerdao;
import com.jsp.HotelManagementSystem.dao.Roomdao;
import com.jsp.HotelManagementSystem.dto.Booking;
import com.jsp.HotelManagementSystem.dto.Customer;
import com.jsp.HotelManagementSystem.dto.Room;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Service
public class Bookingservice {
	
	@Autowired
	private Bookingdao bookingdao;
	
	@Autowired
	private Customerdao customerdao;
	
	@Autowired
	private Roomdao roomdao;
	
	Responsestructure<Booking> responsestructure = new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Booking>> saveBooking(Booking booking, int cid, int rid)
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
			responsestructure.setMessage("Booking saved successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(bookingdao.saveBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.CREATED); 
		}
		else
		{
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<Booking>>  updateBooking(Booking booking, int bid)
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
				responsestructure.setMessage("updated successfully");
				responsestructure.setStatus(HttpStatus.OK.value());
				responsestructure.setData(bookingdao.updateBooking(booking));
				return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK); 
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.deleteBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK); 
		}
		else
		{
			return null;
		}
		
	}
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(booking);
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.FOUND); 
		}
		else
		{
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<List<Booking>>> getallBookings()
	{
		Responsestructure<List<Booking>> responsestructure = new Responsestructure<>();
		if (bookingdao.getallBookings()!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(bookingdao.getallBookings());
			return new ResponseEntity<Responsestructure<List<Booking>>>(responsestructure,HttpStatus.FOUND); 
		}
		return null;
	}
	
	public ResponseEntity<Responsestructure<Booking>> CloseBooking(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			LocalDateTime check_out_date = LocalDateTime.now();
			booking.setCheck_out_date(check_out_date);
			Room room=booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			responsestructure.setMessage("successfully closed the booking");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.updateBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK); 
		}
		else
		{
			return null;
		}
	}
	
}
