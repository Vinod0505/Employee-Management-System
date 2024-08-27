package com.hpe.ems.controller;

import java.util.List; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.ems.model.Employee;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ErrorStructure;
import com.hpe.ems.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController("api/")
public class EmployeeController {

	private EmployeeService employeeService;


	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("employees")
	@Operation(description = "This endpoint is used to add new employee to the database", responses = {
			@ApiResponse(responseCode = "200", description = "Employee object created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input")
	})
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}

	@PutMapping("employees/{employeeId}")
	@Operation(description = "This endpoint is used to update employee details ", responses = {
			@ApiResponse(responseCode = "200", description = "Employee updated  successfully"),
			@ApiResponse(responseCode = "404", description = "Employee not exists with the given Id", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))	
			})
	})
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee updatedEmployee,@PathVariable long employeeId){
		return employeeService.updateEmployee(updatedEmployee,employeeId);
	}

	@GetMapping("employees")
	@Operation(description = "This endpoint will fetch all employees from the database ", responses = {
			@ApiResponse(responseCode = "302", description = "Employees list fetched successfully"),
			@ApiResponse(responseCode = "404", description = "Employees list is null", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))	
			})
	})
	public ResponseEntity<ResponseStructure<List<Employee>>> listOfEmployees(){
		return employeeService.listOfEmployees();
	}

	@DeleteMapping("employees/{employeeId}")
	@Operation(description = "This endpoint will delete the employee based on he ID ", responses = {
			@ApiResponse(responseCode = "200", description = "Employee Deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Employees not exists with the given ID", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))	
			})
	})
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable long employeeId){
		return employeeService.deleteEmployee(employeeId);
	}
}
