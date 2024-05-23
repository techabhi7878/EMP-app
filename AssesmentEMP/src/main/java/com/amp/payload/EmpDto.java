package com.amp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmpDto {
	
	 private int id;
	    private String name;
	    private String position;
	    private String email;
	    private String gender;
	    private String workmode;
	    private String salary;
	    private int mobileNo;

}
