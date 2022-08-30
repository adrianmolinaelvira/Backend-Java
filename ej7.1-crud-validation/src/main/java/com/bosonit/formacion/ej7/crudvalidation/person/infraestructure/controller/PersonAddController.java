package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonServiceImp;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PersonAddController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/person")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personInputDto) throws Exception {
            return personServiceImp.addPerson(personInputDto);
    }
}
