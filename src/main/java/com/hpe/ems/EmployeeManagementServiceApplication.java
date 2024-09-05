package com.hpe.ems;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.hpe.ems.model.Employee;

@SpringBootApplication
public class EmployeeManagementServiceApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmployeeManagementServiceApplication.class, args);
		Employee employee = applicationContext.getBean(Employee.class);
	}

}
