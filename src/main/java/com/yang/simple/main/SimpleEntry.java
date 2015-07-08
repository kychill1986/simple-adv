package com.yang.simple.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleEntry {

	public static void main(String[] args) {
		SpringApplication.run("classpath:applicationContext.xml", args);
	}

}
