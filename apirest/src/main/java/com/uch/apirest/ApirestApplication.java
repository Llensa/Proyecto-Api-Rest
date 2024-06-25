package com.uch.apirest;

import com.uch.apirest.repository.CerealRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestApplication{
	@Autowired
	private CerealRepository cerealRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

}
