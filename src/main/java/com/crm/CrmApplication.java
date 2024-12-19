package com.crm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
	
	//This is the main class for the Spring Boot application.
	//It is annotated with @SpringBootApplication which automatically configures the application.
	//It includes the auto-configuration of Spring Boot features, including the embedded Tomcat server,
    //and the default configuration of Spring MVC.


}
