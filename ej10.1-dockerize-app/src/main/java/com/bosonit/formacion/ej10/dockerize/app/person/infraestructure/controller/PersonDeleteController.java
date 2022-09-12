package com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller;

import com.bosonit.formacion.ej10.dockerize.app.person.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDeleteController {

    @Autowired
    PersonService personServiceImp;

    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable int id) throws Exception {
        return personServiceImp.deletePerson(id);
    }
}
