package com.bosonit.formacion.ej7.crudvalidation.teacher.domain;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(generator = "student-seq")
    @GenericGenerator(name = "student-seq",
            strategy = "com.bosonit.formacion.ej7.crudvalidation.generators.StringIdGenerator")
    private String id_teacher;

    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;

    private String comments;

    @Column(nullable = false)
    private String branch;
}
