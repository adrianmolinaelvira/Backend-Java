package com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller;

import com.bosonit.formacion.ej10.dockerize.app.person.application.PersonService;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonFindAllController {

    @Autowired
    PersonService personServiceImp;

    @GetMapping("/person/all")
    public List<PersonOutputDto> getAllPeople(){
        return personServiceImp.getAllPeople();
    }
}