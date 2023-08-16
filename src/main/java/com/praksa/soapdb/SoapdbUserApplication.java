package com.praksa.soapdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.praksa.soapdb")
public class SoapdbUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapdbUserApplication.class, args);
	}

}
