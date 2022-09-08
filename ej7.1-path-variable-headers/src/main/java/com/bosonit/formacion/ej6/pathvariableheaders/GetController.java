package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class GetController {

    @Autowired
    PersonCRUD crud;

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable int id){
        Person person = crud.getPersonById(id);

        return person == null ? "Persona no encontrada" : person.toString();
    }

    @GetMapping("/nombre/{name}")
    public String getPersonByName(@PathVariable String name){
        Person person = crud.getPersonByName(name);

        return person == null ? "Persona no encontrada" : person.toString();
    }
}
