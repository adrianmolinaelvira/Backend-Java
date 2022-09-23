package com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller;

import com.bosonit.formacion.ej13.mongodb.person.application.PersonService;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonController {

    @Autowired
    PersonService personService;

    @PutMapping("/person/{id}")
    PersonOutputDto updatePerson(@PathVariable String id, @RequestBody PersonInputDto personInputDto){
        return personService.updatePerson(id, personInputDto);
    }

}
