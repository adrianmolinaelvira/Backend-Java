package com.bosonit.formaci.n.Ejercicio51;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/user/{name}")
    public String getName(@PathVariable("name") String name){
        return "Hola " + name;
    }

    @PostMapping("/useradd")
    public String addUser(@RequestBody Person person){
        person.setAge(person.getAge() + 1);
        return "Hola "+ person.getName();
    }

    @GetMapping("/userget")
    public Person getUser(@RequestBody Person person){
        person.setAge(person.getAge() + 1);
        return person;
    }
}
