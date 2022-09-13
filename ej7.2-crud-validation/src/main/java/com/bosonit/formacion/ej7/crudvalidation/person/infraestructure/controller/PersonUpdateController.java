package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonUpdateController {

    @Autowired
    PersonService personServiceImp;

    @PutMapping("/person/{id}")
    @CrossOrigin
    public PersonOutputDto updatePerson(@PathVariable int id, @RequestBody PersonInputDto personInputDto) throws Exception {
        return personServiceImp.updatePerson(id, personInputDto);
    }
}
