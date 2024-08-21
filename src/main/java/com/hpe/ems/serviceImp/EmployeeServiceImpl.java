package com.hpe.ems.serviceImp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hpe.ems.model.Employee;
import com.hpe.ems.repo.EmployeeRepo;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ResponseStructure;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	
	@Override
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
