package com.hpe.ems.exception;

public class EmployeeNotFoundByIdException extends RuntimeException {

	private String message;

	public EmployeeNotFoundByIdException(String message) {
		this.message=message;
	}


	@Override
	public String getMessage() {
		return message;
	}
}
