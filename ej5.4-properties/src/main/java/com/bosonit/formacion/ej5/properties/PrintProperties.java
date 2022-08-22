package com.bosonit.formacion.ej5.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PrintProperties {

    @Value("${greeting}") //Se carga desde application.properties
    private String greeting;

    @Value("${my.number}")
    private int myNumber;

    private String newProperty;

    @Autowired
    private Environment enviroment;

    @Value("${greeting}") //Se carga desde application.yml

    private String greeting2;

    @Value("${my.number}")
    private int myNumber2;

    public void firstMethod(){
        System.out.println("El valor de greeting es: " + greeting);
        System.out.println("El valor de my.number es: " + myNumber);
        this.newProperty = enviroment.getProperty("new.property");
        System.out.println("El valor de new.property es: " + newProperty);
    }

    public void secondMethod(){
        System.out.println("El valor de greeting es: " + greeting2);
        System.out.println("El valor de my.number es: " + myNumber2);
    }
}
