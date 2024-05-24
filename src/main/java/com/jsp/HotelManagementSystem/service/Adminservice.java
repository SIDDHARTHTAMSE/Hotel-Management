package com.jsp.HotelManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Admindao;
import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dto.Admin;
import com.jsp.HotelManagementSystem.dto.Hotel;

@Service
public class Adminservice {
	
	@Autowired
	private Admindao admindao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	public Admin saveAdmin(Admin admin, int hid)
	{
		Hotel hotel=hoteldao.gethotelbyid(hid);
		admin.setHotel(hotel);
		Admin admin2=admindao.saveAdmin(admin);
		if(admin2!=null)
		{
			return admin2;
		}
		else
		{
			return null;
		}
	}
	public Admin updateAdmin(int aid, Admin admin)
	{
		Admin dbAdmin=admindao.getAdminbyid(aid);
		admin.setHotel(dbAdmin.getHotel());
		if(dbAdmin!=null)
		{
			admin.setAdmin_id(aid);
			return admindao.updateAdmin(admin);
		}
		else
		{
			return null;
		}
	}
	public Admin deleteAdmin(int aid)
	{
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null)
		{
			return admindao.deleteAdmin(admin);
		}
		else
		{
			return null;
		}
	}
	public Admin getadminbyemail(String email)
	{
		Admin admin=admindao.getAdminbyemail(email);
		if(admin!=null)
		{
			return admin;
		}
		else
		{
			return null;
		}
	}
	public List<Admin> getallAdmin()
	{
		return admindao.getalladmin();
	}
	public Admin loginAdmin(String email, String password)
	{
		Admin admin=admindao.getAdminbyemail(email);
		if(admin.getAdmin_password().equals(password))
		{
			return admin;
		}
		return null;
	}
	
	
}
