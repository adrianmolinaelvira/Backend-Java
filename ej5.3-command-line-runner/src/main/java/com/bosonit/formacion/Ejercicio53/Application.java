package com.bosonit.formacion.Ejercicio53;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		secondFunc();
		thirdFunc(args);
	}

	public void secondFunc(){
		System.out.println("Hola desde clase secundaria");
	}

	public void thirdFunc(String... args){
		for(String arg : args)
			System.out.println(arg);
	}
}
