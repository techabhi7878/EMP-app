package com.amp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssesmentEmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssesmentEmpApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
