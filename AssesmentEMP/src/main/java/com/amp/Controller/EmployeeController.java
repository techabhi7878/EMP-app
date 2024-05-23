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

import com.amp.Services.EmpServices;
import com.amp.payload.ApiResponse;
import com.amp.payload.EmpDto;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmpServices empServices;
	//create Employee
	@PostMapping("/")
	public ResponseEntity<EmpDto>createEmployee(@RequestBody EmpDto empDto){
		EmpDto createEmployee = this.empServices.createEmployee(empDto);
		
		return  new ResponseEntity<EmpDto>(createEmployee,HttpStatus.CREATED);
		
	}
	//Update Employee
	@PutMapping("/{eid}")
	public ResponseEntity<EmpDto> updateEmployee
	(@RequestBody EmpDto empDto,@PathVariable Integer eid){
		EmpDto updatEmployee = this.empServices.updatEmployee(empDto, eid);
		
		return new ResponseEntity<EmpDto>(updatEmployee,HttpStatus.OK);
	}
	// delete Employee
	@DeleteMapping("/{eid}")
	public ResponseEntity<ApiResponse>deletEmpolyee(@PathVariable Integer eid){
		this.empServices.deleteEmployee(eid);
		return new ResponseEntity<ApiResponse>(new ApiResponse
				("Empolyee is deleted Successfully",true),HttpStatus.OK);
		
	}
	// get Employee by id
	@GetMapping("/{eid}")
	public ResponseEntity<EmpDto> getEmployeeById(@RequestBody EmpDto empDto,@PathVariable Integer eid){
		EmpDto employee = this.empServices.getEmployee(empDto,eid);
		return new ResponseEntity<EmpDto>(employee,HttpStatus.OK);
		
	}
	//getAll Employee
	public ResponseEntity<List<EmpDto>> getAllEmployee(){
		List<EmpDto> allEmployee = this.empServices.getAllEmployee();
		return  ResponseEntity.ok(allEmployee);
		
	}
	

}
