package com.bosonit.formation.Ejercicio52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired
    private Person person;

    @Autowired
    private CitiesImpl citiesImpl;

    @Autowired
    @Qualifier("getBean1")
    private Person bean1;

    @Autowired
    @Qualifier("getBean2")
    private Person bean2;

    @Autowired
    @Qualifier("getBean3")
    private Person bean3;

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

        citiesImpl.citiesList.add(newCity);

        return newCity;
    }

    @GetMapping("controlador1/bean/{bean}")
    public Person getBean(@PathVariable String bean) throws Exception {

        switch (bean){

            case "bean1":
                return bean1;
            case "bean2":
                return bean2;
            case "bean3":
                return bean3;
            default:
                throw new Exception("Bean does not exist");
        }
    }
}
