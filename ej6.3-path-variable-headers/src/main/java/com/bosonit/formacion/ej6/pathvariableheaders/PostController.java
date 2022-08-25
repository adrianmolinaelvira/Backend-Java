package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PostController {

    @Autowired
    PersonCRUD crud;

    @PostMapping("")
    public String addPerson(@RequestBody Person newPerson){
        crud.addPersonToList(newPerson);

        return "Persona añadida";
    }
}
