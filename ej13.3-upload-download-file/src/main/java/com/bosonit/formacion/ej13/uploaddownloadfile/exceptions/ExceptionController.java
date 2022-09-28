package com.bosonit.formacion.ej13.uploaddownloadfile.exceptions;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.domain.File;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;


@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(FileNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomeError handleFileNotFoundException(FileNotFound exception) {
        return new CustomeError(exception.getMessage(), 404L, LocalDateTime.now());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public CustomeError handleRunTimeException(RuntimeException exception) {
        return new CustomeError(exception.getMessage(), 406L, LocalDateTime.now());
    }
}
