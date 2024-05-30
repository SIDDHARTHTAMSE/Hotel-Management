package com.jsp.HotelManagementSystem.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Hotelservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@RestController
@RequestMapping("/hotel")
public class Hotelcontroller {
	
	@Autowired
	private Hotelservice hotelservice;

//	@ApiOperation(value = "save hotel", notes = "api is used to save hotel")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "201", description = "hotel successfully created"
					),
					@ApiResponse(
							responseCode = "404", description = "hotel not saved give proper input"
					)
			}
	)
	@ResponseStatus(
			value = HttpStatus.CREATED,
			reason = "Hotel created successfully"
	)
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(@RequestBody Hotel hotel)
	{
		return hotelservice.saveHotel(hotel);
	}
//
//	//@ApiOperation(value = "update hotel", notes = "api is used to update hotel")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "hotel successfully updated"
					),
					@ApiResponse(
							responseCode = "404",
							description = "hotel not updated give proper input"
					)
			}
	)
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(@RequestParam int hid, @RequestBody Hotel hotel)
	{
		return hotelservice.updateHotel(hid, hotel);
	}
//
//	//@ApiOperation(value = "delete hotel", notes = "api is used to delete hotel")
//	//@ApiResponses(value = (@ApiResponse(code = 200, message = "hotel successfully deleted"),
//			@ApiResponse(code = 404,message = "hotel not deleted give proper input")))
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(@RequestParam int hid)
	{
		return hotelservice.deleteHotel(hid);
	}

//	//@ApiOperation(value = "get hotel by id", notes = "api is used to get hotel details based on id")
//	//@ApiResponses(value = (@ApiResponse(code = 201, message = "successfully found hotel"),
//			@ApiResponse(code = 404,message = "hotel not found give proper input")))
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(@RequestParam int hid)
	{
		return hotelservice.getHotelbyid(hid);
	}
	 
}
