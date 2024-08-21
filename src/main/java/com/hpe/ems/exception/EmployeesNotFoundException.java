package com.hpe.ems.exception;

public class EmployeesNotFoundException extends RuntimeException {

	private String message;

	public EmployeesNotFoundException(String message) {
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
