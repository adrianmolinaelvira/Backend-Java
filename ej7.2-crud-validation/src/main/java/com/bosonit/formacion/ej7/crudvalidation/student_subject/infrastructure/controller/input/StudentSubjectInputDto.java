package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;

import java.util.Date;

@Data
public class StudentSubjectInputDto {

    private String id_teacher;

    private String subject;

    private String comments;

    private Date initial_date;

    private Date finish_date;

    public StudentSubject transformIntoStudentSubject(Teacher teacher){
        StudentSubject newStudentSubject = new StudentSubject();

        newStudentSubject.setTeacher(teacher);
        newStudentSubject.setSubject(this.subject);
        newStudentSubject.setComments(this.comments);
        newStudentSubject.setInitial_date(this.initial_date);
        newStudentSubject.setFinish_date(this.finish_date);

        return newStudentSubject;
    }
}
