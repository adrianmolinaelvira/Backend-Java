package com.bosonit.formation.Ejercicio52;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CitiesList {

    @Bean
    public List<City> getCitiesList(){
        return new ArrayList<City>();
    }
}
