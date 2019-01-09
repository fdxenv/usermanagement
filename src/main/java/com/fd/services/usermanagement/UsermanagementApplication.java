package com.fd.services.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.fd.services.usermanagement", "com.fd.services.usermanagement.controller" , "com.fd.services.usermanagement.configuration","com.fd.services.usermanagement.dao","com.fd.services.usermanagement.entity"})
public class UsermanagementApplication {

	
	   
	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

}

