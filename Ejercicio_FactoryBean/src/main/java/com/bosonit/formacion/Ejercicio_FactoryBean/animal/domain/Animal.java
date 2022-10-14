package com.bosonit.formacion.Ejercicio_FactoryBean.animal.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {

    private String name;

    public String getType(){
        return name;
    }
}
