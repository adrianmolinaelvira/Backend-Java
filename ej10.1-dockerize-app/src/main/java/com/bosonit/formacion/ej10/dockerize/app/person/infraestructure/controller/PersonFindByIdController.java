package com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller;

import com.bosonit.formacion.ej10.dockerize.app.person.application.PersonService;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonFindByIdController {

    @Autowired
    PersonService personServiceImp;

    @GetMapping("/person/{id}")
    public PersonOutputDto getPersonById(@PathVariable int id) throws Exception {
        return personServiceImp.findPersonById(id);
    }
}
