package com.amp.Services;

import java.util.List;

import com.amp.payload.EmpDto;

public interface EmpServices {
	//create employee
	EmpDto createEmployee(EmpDto empDto);
	
	//update employee
	EmpDto updatEmployee(EmpDto empDto,Integer eid);
	
	//delete employee
	
    void deleteEmployee(Integer eid);
    
    //get employee
    EmpDto getEmployee(EmpDto empDto,Integer eid);
    
    // get All employee
    
    List<EmpDto> getAllEmployee();
    
	
	
	
   
}
