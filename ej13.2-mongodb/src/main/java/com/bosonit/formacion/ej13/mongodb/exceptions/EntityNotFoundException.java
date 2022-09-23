package com.bosonit.formacion.ej13.mongodb.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message){
        super(message);
    }
}
