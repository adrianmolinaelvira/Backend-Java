package com.bosonit.formacion.ej6.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@org.springframework.context.annotation.Configuration
@PropertySource("miconfiguracion.properties")
@RestController
public class Configuration {

    @Value("${valor1}")
    private String valor1;

    @Value("${valor2}")
    private String valor2;

    @PostConstruct
    private void postConstruct(){
        System.out.println(valor1 + " " + valor2);
    }

    @GetMapping("/miconfiguracion")
    public String getMiConfiguracion(){
        return valor1 + " " + valor2;
    }
}
