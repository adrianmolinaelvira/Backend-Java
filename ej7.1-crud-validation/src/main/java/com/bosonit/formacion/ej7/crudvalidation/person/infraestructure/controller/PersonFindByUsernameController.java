package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonFindByUsernameController {

    @Autowired
    PersonService personServiceImp;

    @GetMapping("/person/username/{username}")
    public List<PersonOutputDto> getPersonByUsername(@PathVariable String username) throws Exception {
        return personServiceImp.findPersonByUsername(username);
    }
}
