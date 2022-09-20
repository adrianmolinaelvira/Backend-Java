package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonPage;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonSearchCriteria;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDtoWithRoleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonFindController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    @CrossOrigin
    public PersonOutputDtoWithRoleDetails getPersonById(@PathVariable int id) throws Exception {
        return personService.findPersonById(id);
    }

    @GetMapping("/criteria")
    public Page<PersonOutputDto> getPersonByCriteria(@RequestParam(required = false) String username, @RequestParam(required = false) String name,
                                                     @RequestParam(required = false) String surname, @RequestParam(required = false) Date creationDate,
                                                     @RequestParam(required = false) String dateCriteria, @RequestParam(required = false) String sortBy,
                                                     @RequestParam Integer page){


        return personService.getData(new PersonPage(page, sortBy),
                new PersonSearchCriteria(username, name, surname, creationDate, dateCriteria));
    }
}
