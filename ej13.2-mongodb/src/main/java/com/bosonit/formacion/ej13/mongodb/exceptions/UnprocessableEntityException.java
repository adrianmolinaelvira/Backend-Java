package com.bosonit.formacion.ej13.mongodb.exceptions;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message){
        super(message);
    }
}
