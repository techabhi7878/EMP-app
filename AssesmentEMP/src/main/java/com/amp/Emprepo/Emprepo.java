package com.amp.Emprepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amp.Entity.Employee;

public interface Emprepo  extends JpaRepository<Employee, Integer>{

}
