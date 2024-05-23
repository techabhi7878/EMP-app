package com.amp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amp.Services.AddressService;
import com.amp.payload.AddressDto;
import com.amp.payload.ApiResponse;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//create Address
	@PostMapping("/")
	public ResponseEntity<AddressDto>createAddress(@RequestBody AddressDto addressDto){
		
	AddressDto createAddress = this.addressService.createAddress(addressDto);
		
		return new ResponseEntity<AddressDto>(createAddress,HttpStatus.CREATED);
	}
	// update address
	@PutMapping("/{aid}")
	public ResponseEntity<AddressDto>updateAddress(@RequestBody
			
		  AddressDto addressDto,@PathVariable Integer aid){
		
		AddressDto updateAddress = this.addressService.updateAddress(addressDto, aid);
		
		
		return new ResponseEntity<AddressDto>(updateAddress,HttpStatus.OK);
	}
	
	//delete Address
	@DeleteMapping("/{aid}")
	public ResponseEntity<ApiResponse>deleteAddress(@PathVariable Integer aid){
		this.addressService.deleteAddress(aid);
		return new ResponseEntity<ApiResponse>
		(new ApiResponse("Address deleted successfully",true),HttpStatus.OK);
	}
	//get single Address
	@GetMapping("/{aid}")
	public ResponseEntity<AddressDto>getAddressById
	(@RequestBody AddressDto addressDto,@PathVariable Integer aid){
		AddressDto addressById = this.addressService.getAddressById(addressDto, aid);
		return new ResponseEntity<AddressDto>(addressById,HttpStatus.OK);
		
	}
	//get all address
	@GetMapping("/")
	public ResponseEntity<List<AddressDto>>getAllAddress(){
		
		List<AddressDto> allAddress = this.addressService.getAllAddress();
		
		return ResponseEntity.ok(allAddress);
	}
	
	


}
