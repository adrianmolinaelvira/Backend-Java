package com.bosonit.formacion.ej13.uploaddownloadfile;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.application.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileService.deleteAll(args[0]);
		fileService.init(args[0]);
	}
}
