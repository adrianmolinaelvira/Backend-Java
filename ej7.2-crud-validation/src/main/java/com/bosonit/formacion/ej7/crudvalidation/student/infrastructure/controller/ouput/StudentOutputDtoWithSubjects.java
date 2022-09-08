package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput;

import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDtoWithoutStudents;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class StudentOutputDtoWithSubjects {

    private String id_student;
    private PersonOutputDto person;
    private int num_hours_week;
    private String comments;
    private TeacherOutputDto teacher;
    private String branch;
    private List<StudentSubjectOutputDtoWithoutStudents> subjects;

    public StudentOutputDtoWithSubjects(Student student){
        setId_student(student.getId_student());
        setPerson(new PersonOutputDto(student.getPerson()));
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setTeacher(student.getTeacher() != null ? new TeacherOutputDto(student.getTeacher()) : null);
        setBranch(student.getBranch());

        List<StudentSubjectOutputDtoWithoutStudents> subjectsOutputDto = student.getStudentSubjects().stream().map(StudentSubjectOutputDtoWithoutStudents::new).collect(Collectors.toList());

        setSubjects(subjectsOutputDto);
    }
}
