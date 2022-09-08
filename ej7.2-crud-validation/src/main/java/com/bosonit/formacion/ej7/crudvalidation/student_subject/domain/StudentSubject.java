package com.bosonit.formacion.ej7.crudvalidation.student_subject.domain;


import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class StudentSubject {

    @Id
    @GeneratedValue(generator = "student-seq")
    @GenericGenerator(name = "student-seq",
            strategy = "com.bosonit.formacion.ej7.crudvalidation.generators.StringIdGenerator")
    private String id_subject;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_studentSubject",
            joinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_student",
                    referencedColumnName = "id_student"))
    private List<Student> students;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    private String subject;

    private String comments;

    private Date initial_date;

    private Date finish_date;
}
