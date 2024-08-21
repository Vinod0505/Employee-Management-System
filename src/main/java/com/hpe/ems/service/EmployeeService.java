package com.hpe.ems.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hpe.ems.model.Employee;
import com.hpe.ems.utility.ResponseStructure;

public interface EmployeeService {

	ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee);

	ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee updatedEmployee,long employeeId);

	ResponseEntity<ResponseStructure<List<Employee>>> listOfEmployees();

	
}
