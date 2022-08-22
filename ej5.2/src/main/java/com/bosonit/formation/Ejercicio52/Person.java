package com.bosonit.formation.Ejercicio52;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Person {

    private String name, city;
    private int age;

    public Person(){

    }

    public Person(String name){
        setName(name);
    }

}
