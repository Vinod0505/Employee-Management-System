package com.hpe.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.ems.model.Employee;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ResponseStructure;

@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee){
		return employeeService.addEmployee(employee);
	}

}
