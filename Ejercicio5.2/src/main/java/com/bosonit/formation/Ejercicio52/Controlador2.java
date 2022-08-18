package com.bosonit.formation.Ejercicio52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    private Person person;

    @Autowired
    private List<City> citiesList;

    @GetMapping("/controlador2/getPerson")
    public Person getPerson(){
        return this.person;
    }

    @GetMapping("controlador2/getCities")
    public List<City> getCitiesList(){
        return  citiesList;
    }

}
