package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput;

import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import lombok.Data;

@Data
public class StudentOutputDto {

    private String id_student;
    private PersonOutputDto personOutputDto;
    private int num_hours_week;
    private String comments;
    private TeacherOutputDto teacherOutputDto;
    private String branch;

    public StudentOutputDto(Student student){
        setId_student(student.getId_student());
        setPersonOutputDto(new PersonOutputDto(student.getPerson()));
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setTeacherOutputDto(student.getTeacher() != null ? new TeacherOutputDto(student.getTeacher()) : null);
        setBranch(student.getBranch());
    }
}
