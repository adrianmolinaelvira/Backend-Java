package com.bosonit.formacion.ej13.uploaddownloadfile.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class CustomeError {

    String message;
    Long httpStatus;
    LocalDateTime timeStamtp;
}
