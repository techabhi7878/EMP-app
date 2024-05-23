package com.amp.Services;

import java.util.List;

import com.amp.payload.AddressDto;

public interface AddressService {
	
	//create Address
	    AddressDto createAddress(AddressDto addressDto);
	//update Address
	AddressDto updateAddress(AddressDto addressDto,Integer aid);
	//delete Address
	void deleteAddress(Integer aid);
	//get single Address
	 AddressDto getAddressById(AddressDto addressDto,Integer aid);
	//get AllAddress
	 List<AddressDto> getAllAddress();

}
