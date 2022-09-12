package com.bosonit.formacion.ej10.dockerize.app.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException{

    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String message, int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }
}
