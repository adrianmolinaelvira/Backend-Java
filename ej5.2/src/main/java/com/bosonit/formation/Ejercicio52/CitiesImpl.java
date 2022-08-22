package com.bosonit.formation.Ejercicio52;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CitiesImpl {

    List<City> citiesList = new ArrayList<City>();
    @Bean
    public CitiesImpl getCitiesList() {
        return new CitiesImpl();
    }

    public List<City> getCitiesListProperty(){
        return this.citiesList;
    }
}
