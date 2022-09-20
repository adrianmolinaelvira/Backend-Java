package com.bosonit.formacion.ej7.crudvalidation.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonSearchCriteria {

    private String username;
    private String name;
    private String surname;
    private Date created_date;
    private String dateCriteria;
}
