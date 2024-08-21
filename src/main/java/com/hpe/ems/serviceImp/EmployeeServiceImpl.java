package com.hpe.ems.serviceImp;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hpe.ems.exception.EmployeeNotFoundByIdException;
import com.hpe.ems.model.Employee;
import com.hpe.ems.repo.EmployeeRepo;
import com.hpe.ems.service.EmployeeService;
import com.hpe.ems.utility.ResponseStructure;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	private ResponseStructure<Employee> responseStructure;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo,ResponseStructure<Employee> responseStructure) {
		super();
		this.employeeRepo = employeeRepo;
		this.responseStructure=responseStructure;
	}


	@Override
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) {
		employeeRepo.save(employee);
		responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Employee added Succesfully");
		responseStructure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee updatedEmployee,long employeeId) {
		return employeeRepo.findById(employeeId)
				.map(employee -> {
					updatedEmployee.setEmployeeId(employee.getEmployeeId());
					employeeRepo.save(updatedEmployee);
					return ResponseEntity.ok(
							responseStructure.setStatusCode(HttpStatus.OK.value())
							.setMessage("Employee Updated Successfully")
							.setData(updatedEmployee)
							);

				})
				.orElseThrow(()->new EmployeeNotFoundByIdException("Employee object not found"));
	}

}
