package com.bosonit.formacion.Ejercicio53;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Component1 {

    @PostConstruct //Se ejecuta cuando se instancia
    public void firsFunc(){
        System.out.println("Hola desde clase inicial");
    }
}
