package com.bosonit.formacion.ej10.dockerize.app.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Data
public class UnprocessableEntityException extends RuntimeException{

    Date timeStamp;
    int httpCode;

    public UnprocessableEntityException(String message, int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }
}
