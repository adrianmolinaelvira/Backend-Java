package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput;

import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentSubjectOutputDtoWithoutStudents {

    private String id_subject;

    private TeacherOutputDto teacherOutputDto;

    private String subject;

    private String comments;

    private Date initial_date;

    private Date finish_date;

    public StudentSubjectOutputDtoWithoutStudents(StudentSubject studentSubject){
        setId_subject(studentSubject.getId_subject());
        setTeacherOutputDto(new TeacherOutputDto(studentSubject.getTeacher()));
        setSubject(studentSubject.getSubject());
        setComments(studentSubject.getComments());
        setInitial_date(studentSubject.getInitial_date());
        setFinish_date(studentSubject.getFinish_date());
    }
}
