package com.bosonit.formacion.BackendFrontend161.Exceptions;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message){
        super(message);
    }
}
