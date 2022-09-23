package com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller;

import com.bosonit.formacion.ej13.mongodb.person.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePersonController {

    @Autowired
    PersonService personService;

    @DeleteMapping("/person/{id}")
    String deletePerson(@PathVariable String id){
        return personService.deletePerson(id);
    }
}
