package com.bosonit.formacion.Backend161.Exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException {
    String message;
    LocalDate localDate;

    public CustomException(String message){
        this.message = message;
        localDate = LocalDate.now();
    }
}
