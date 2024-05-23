package com.amp.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.amp.Emprepo.Emprepo;
import com.amp.Entity.Employee;
import com.amp.Exception.ResourceNotFoundException;
import com.amp.Services.EmpServices;
import com.amp.payload.EmpDto;

@Service
public class EmployeeServiceImpl implements EmpServices{
	@Autowired
	private Emprepo emprepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmpDto createEmployee(EmpDto empDto) {
		Employee emp = this.modelMapper.map(empDto, Employee.class);
		Employee saveEmp = this.emprepo.save(emp);
		return modelMapper.map(saveEmp, EmpDto.class);
	}

	@Override
	public EmpDto updatEmployee(EmpDto empDto, Integer eid) {
	Employee employee=	this.emprepo.findById(eid).orElseThrow(()-> new ResourceNotFoundException
			      ("Employee","EmployeeId",eid));
	       employee.setId(empDto.getId());
	       employee.setEmail(empDto.getEmail());
	       employee.setName(empDto.getName());
	       employee.setPosition(empDto.getPosition());
	       employee.setMobileNo(empDto.getMobileNo());
	       employee.setSalary(empDto.getSalary());
	          
	          Employee updateEmp = this.emprepo.save(employee);
		          
		return modelMapper.map(updateEmp,EmpDto.class);
	}

	@Override
	public void deleteEmployee(Integer eid) {
		Employee employee = this.emprepo.findById(eid).orElseThrow(()-> new ResourceNotFoundException
				("Employee", "EmployeeId",eid));
		     this.emprepo.delete(employee);
		
	}

	@Override
	public EmpDto getEmployee(EmpDto empDto, Integer eid) {
	    Employee employee = this.emprepo.findById(eid).orElseThrow(()-> new ResourceNotFoundException
	    		("Employee", "EmployeeId", eid));
		return modelMapper.map(employee, EmpDto.class);
	}

	@Override
	public List<EmpDto> getAllEmployee() {
		List<Employee> employeeList = this.emprepo.findAll();
		List<EmpDto> empDtos=employeeList.stream().map(employee-> modelMapper.map(employee, EmpDto.class))
                .collect(Collectors.toList());
		return empDtos;
	}

}
