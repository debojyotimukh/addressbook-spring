package com.bridgelabz.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressbookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AddressbookApplication.class, args);
		log.info("Address Book App started in {}", context.getEnvironment().getProperty("environment"));
	}

}
