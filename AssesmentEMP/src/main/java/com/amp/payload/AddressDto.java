package com.amp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDto {
	private int aId;
	private String country;
	private String state;
	private String city;
	private String pinCode;

}
