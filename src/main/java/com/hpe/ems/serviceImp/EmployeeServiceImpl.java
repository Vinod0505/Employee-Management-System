package com.hpe.ems.serviceImp;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hpe.ems.model.Employee;
import com.hpe.ems.repo.EmployeeRepo;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ResponseStructure;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) {
		employeeRepo.save(employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Employee added Succesfully");
		responseStructure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}

}
