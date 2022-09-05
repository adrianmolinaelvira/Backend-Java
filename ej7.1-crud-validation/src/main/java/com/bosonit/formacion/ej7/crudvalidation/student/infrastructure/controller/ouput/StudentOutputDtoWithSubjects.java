package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput;

import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentOutputDtoWithSubjects {

    private String id_student;
    private PersonOutputDto personOutputDto;
    private int num_hours_week;
    private String comments;
    private TeacherOutputDto teacherOutputDto;
    private String branch;
    private List<StudentSubjectOutputDto> subjects;

    public StudentOutputDtoWithSubjects(Student student, List<StudentSubjectOutputDto> subjects){
        setId_student(student.getId_student());
        setPersonOutputDto(new PersonOutputDto(student.getPerson()));
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setTeacherOutputDto(student.getTeacher() != null ? new TeacherOutputDto(student.getTeacher()) : null);
        setBranch(student.getBranch());
        setSubjects(subjects);
    }
}
