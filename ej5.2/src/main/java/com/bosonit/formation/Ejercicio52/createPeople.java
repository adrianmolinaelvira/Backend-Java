package com.bosonit.formation.Ejercicio52;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class createPeople {

    @Bean
    public Person getBean1(){
        return new Person("bean1");
    }

    @Bean
    public Person getBean2(){
        return new Person("bean2");
    }

    @Bean
    public Person getBean3(){
        return new Person("bean3");
    }
}
