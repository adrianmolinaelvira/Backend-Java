package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonServiceImp;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonFindByIdController {

    @Autowired
    PersonServiceImp personServiceImp;

    @GetMapping("/person/{id}")
    public PersonOutputDto getPersonById(@PathVariable int id) throws Exception {
        return personServiceImp.findPersonById(id);
    }
}
