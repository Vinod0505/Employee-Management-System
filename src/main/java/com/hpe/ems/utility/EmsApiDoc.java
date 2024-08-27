package com.hpe.ems.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class EmsApiDoc {

	@Bean
	Info info() {
		return new Info().title("EmployeeManagementSystem")
				.description("RestFulApi managing all the endpoints")
				.version("v1")
				.contact(contact());
	}

	@Bean
	Contact contact() {

		return new Contact().email("vinodbojaraju@gmail.com").name("vinod").url("vinodbojaraju@gmail.com");
	}

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
}
