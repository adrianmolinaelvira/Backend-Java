package com.bosonit.formacion.ej5.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	PrintProperties printProperties;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println("///Apartado 1///");
		printProperties.firstMethod();
		System.out.println("///Apartado 2///");
		printProperties.secondMethod();
	}

}
