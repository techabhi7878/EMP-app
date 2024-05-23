package com.amp.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.amp.Emprepo.AddRepo;
import com.amp.Entity.Address;
import com.amp.Exception.ResourceNotFoundException;
import com.amp.Services.AddressService;
import com.amp.payload.AddressDto;


@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddRepo addRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		      Address address = this.modelMapper.map(addressDto, Address.class);
		           Address saveAddress = this.addRepo.save(address);
		return  modelMapper.map(saveAddress, AddressDto.class);
	}

	
	@Override
	public AddressDto updateAddress(AddressDto addressDto, Integer aid) {
		            Address address = this.addRepo.findById(aid).orElseThrow(()-> new ResourceNotFoundException
		            		("Address", "AddressId", aid));  
		            address.setAId(addressDto.getAId());
		            address.setCity(addressDto.getCity());
		            address.setCountry(addressDto.getCountry());
		            address.setPinCode(addressDto.getPinCode());
		            address.setState(addressDto.getState());
		            Address updateAdd = this.addRepo.save(address);
		            
		return modelMapper.map(updateAdd, AddressDto.class);
	}

	@Override
	public void deleteAddress(Integer aid) {
		Address address = this.addRepo.findById(aid).orElseThrow(()-> new ResourceNotFoundException
				("Address", "AddressId", aid));
		this.addRepo.delete(address);
		
	}

	@Override
	public AddressDto getAddressById(AddressDto addressDto, Integer aid) {
		Address address = this.addRepo.findById(aid).orElseThrow(()-> new ResourceNotFoundException
        		("Address", "AddressId", aid));
		return modelMapper.map(address, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAllAddress() {
		List<Address> addresses = this.addRepo.findAll();
		List<AddressDto> AllAddress = addresses.stream().map(address->modelMapper.map
				(addresses, AddressDto.class)).collect(Collectors.toList());
		return AllAddress;
	}

}
