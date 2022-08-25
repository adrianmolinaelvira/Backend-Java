package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class DeleteController {

    @Autowired
    PersonCRUD crud;

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id){
        crud.deletePersonFromList(id);

        return "Persona Borrada";
    }
}
