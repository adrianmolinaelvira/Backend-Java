package com.bosonit.formacion.ej5.profiles20;

import com.bosonit.formacion.ej5.profiles20.Profiles.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	Profile profile;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Leyendo las Variables de Entorno");

		profile.readProperties();
	}
}
