package com.hpe.ems.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hpe.ems.exception.EmployeeNotFoundByIdException;
import com.hpe.ems.exception.EmployeesNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

	private ErrorStructure<String> errorStructure;

	public ExceptionHandler(ErrorStructure<String> errorStructure) {
		super();
		this.errorStructure = errorStructure;
	}


	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundByIdException(EmployeeNotFoundByIdException byIdException){
		return ResponseEntity.ok(
				errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value())
				.setErrorMessage(byIdException.getMessage())
				.setData("Employee not exist with given ID")
				);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundException(EmployeesNotFoundException notFoundException){
		return ResponseEntity.ok(
				errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value())
				.setErrorMessage(notFoundException.getMessage())
				.setData("Employees list is null")
				);
	}
}
