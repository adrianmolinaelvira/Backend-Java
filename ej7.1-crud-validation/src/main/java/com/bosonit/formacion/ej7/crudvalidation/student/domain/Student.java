package com.bosonit.formacion.ej7.crudvalidation.student.domain;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "student-seq")
    @GenericGenerator(name = "student-seq",
            parameters = @Parameter(name = "prefix", value = "student"),
            strategy = "com.bosonit.formacion.ej7.crudvalidation.generators.StringIdGenerator")
    private String id_student;

    @OneToOne()
    @JoinColumn(name = "id_person")
    private Person person;

    @Column(nullable = false)
    private Integer num_hours_week;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @Column(nullable = false)
    private String branch;
}
