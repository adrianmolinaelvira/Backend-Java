package com.bosonit.formacion.ej5.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	private MainController loggingSystem;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
