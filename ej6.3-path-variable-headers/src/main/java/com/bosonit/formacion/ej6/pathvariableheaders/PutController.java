package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PutController {

    @Autowired
    PersonCRUD crud;

    @PutMapping("/{id}")
    public String editPerson(@PathVariable int id, @RequestBody Person newPersonData){
        crud.modifyPersonFromList(id, newPersonData);

        return "Persona modificada";
    }

}
