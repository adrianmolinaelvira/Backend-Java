package com.bosonit.formation.Ejercicio52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    private Person person;

    @Autowired
    private List<City> citiesList;

    @GetMapping("controlador1/addPersona")
    public Person addPerson(@RequestHeader String name, @RequestHeader String city, @RequestHeader int age){
        person.setName(name);
        person.setCity(city);
        person.setAge(age);

        return person;
    }

    @PostMapping("controlador1/addCity")
    public City addNewCity(@RequestHeader String name, @RequestHeader int numOfInhabitants){
        City newCity = new City();
        newCity.setName(name);
        newCity.setNumOfInhabitants(numOfInhabitants);

        citiesList.add(newCity);

        return newCity;
    }

}
