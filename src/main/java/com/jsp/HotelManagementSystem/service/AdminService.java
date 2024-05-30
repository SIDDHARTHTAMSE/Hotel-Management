package com.jsp.HotelManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Admindao;
import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dto.Admin;
import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Service
public class Adminservice {
	
	@Autowired
	private Admindao admindao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	Responsestructure<Admin> responsestructure = new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Admin>> saveAdmin(Admin admin, int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		admin.setHotel(hotel);
		Admin admin2=admindao.saveAdmin(admin);
		if(admin2!=null)
		{
			responsestructure.setMessage("admin saved successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(admin2);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.CREATED);
		}
		else
		{
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(int aid, Admin admin)
	{
		Admin dbAdmin=admindao.getAdminbyid(aid);
		admin.setHotel(dbAdmin.getHotel());
		if(dbAdmin!=null)
		{
			admin.setAdmin_id(aid);
			responsestructure.setMessage("updated successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.updateAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(int aid)
	{
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null)
		{
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Admin>> getadminbyemail(String email)
	{
		Admin admin=admindao.getAdminbyemail(email);
		if(admin!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	public ResponseEntity<Responsestructure<List<Admin>>> getallAdmin()
	{
		Responsestructure<List<Admin>> responsestructure = new Responsestructure<>();
		if(admindao.getalladmin()!=null)
		{
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admindao.getalladmin());
			return new ResponseEntity<Responsestructure<List<Admin>>>(responsestructure, HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(String email, String password)
	{
		Admin admin=admindao.getAdminbyemail(email);
		if(admin.getAdmin_password().equals(password))
		{
			responsestructure.setMessage("admin logged in successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}
		else
		{
			responsestructure.setMessage("enter valid email and password");
			responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestructure.setData(null);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(int aid)
	{
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null)
		{
			responsestructure.setMessage("found successfuly");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
	
	
}
