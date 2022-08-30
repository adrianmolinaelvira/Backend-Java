package com.bosonit.formacion.ej7.crudvalidation.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Data
public class EntityNotFoundException extends Exception{

    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String message, int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }
}
