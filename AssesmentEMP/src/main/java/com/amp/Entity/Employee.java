package com.amp.Entity;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee") 
public class Employee {
    @Id
    private int id;
    private String name;
    private String position;
    private String email;
    private String gender;
    private String workmode;
    private String salary;
    private int mobileNo;
   
    
}