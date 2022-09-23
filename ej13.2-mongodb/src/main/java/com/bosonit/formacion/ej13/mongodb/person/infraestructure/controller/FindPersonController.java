package com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller;

import com.bosonit.formacion.ej13.mongodb.person.application.PersonService;
import com.bosonit.formacion.ej13.mongodb.person.domain.Person;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class FindPersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    PersonOutputDto getPersonById(@PathVariable String id){
        return personService.findPerson(id);
    }

    @GetMapping("/getall/{page}")
    Page<PersonOutputDto> getAllPeople(@PathVariable Integer page){
        return personService.getAllPeople(page);
    }

    @GetMapping("/username/{username}")
    List<PersonOutputDto> getPersonByUsername(@PathVariable String username){
        return personService.findPeopleByUsername(username);
    }
}
