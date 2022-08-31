package com.bosonit.formacion.ej7.crudvalidation.student.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    int student_id;
}
