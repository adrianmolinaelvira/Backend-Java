package com.bosonit.formacion.Ejercicio_FactoryBean.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomError {

    private String message;
    private LocalDateTime localDate;

    public CustomError(String message){
        this.message = message;
        this.localDate = LocalDateTime.now();
    }
}
