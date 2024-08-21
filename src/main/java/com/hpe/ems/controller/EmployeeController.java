package com.hpe.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.ems.model.Employee;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ResponseStructure;

@RestController("/")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("employees/add")
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}

	@PutMapping("employees/update/{employeeId}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee updatedEmployee,@PathVariable long employeeId){
		return employeeService.updateEmployee(updatedEmployee,employeeId);
	}
}
