package com.bosonit.formacion.Backend161.Exceptions;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message){
        super(message);
    }
}
