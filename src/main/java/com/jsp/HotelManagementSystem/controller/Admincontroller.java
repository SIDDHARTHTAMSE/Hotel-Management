package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HotelManagementSystem.dto.Admin;
import com.jsp.HotelManagementSystem.service.Adminservice;

@RestController
@RequestMapping("/admin")
public class Admincontroller {
	
	@Autowired
	private Adminservice adminservice;
	
	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin, @RequestParam int hid)
	{
		return adminservice.saveAdmin(admin, hid);
	}
	
	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin, @RequestParam int aid)
	{
		return adminservice.updateAdmin(aid, admin);
	}
	
	@DeleteMapping
	public Admin deleteAdmin(@RequestParam int aid)
	{
		return adminservice.deleteAdmin(aid);
	}
	
	@GetMapping("adminbyid")
	public Admin getAdminbyid(@RequestParam int aid)
	{
		return adminservice.getAdminbyid(aid);
	}
	
	@GetMapping("/adminbyemail")
	public Admin getAdminbyemail(@RequestParam String email)
	{
		return adminservice.getadminbyemail(email);
	} 
	
	@GetMapping("/getalladmin")
	public List<Admin> getallAdmin()
	{
		return adminservice.getallAdmin();
	}
	
	@GetMapping("/loginadmin")
	public Admin loginAdmin(@RequestParam String email, @RequestParam String password)
	{
		return adminservice.loginAdmin(email, password);
	} 
}
