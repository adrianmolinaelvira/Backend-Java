package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;

@Data
public class TeacherOutputDto {

    private String id_teacher;
    private PersonOutputDto personOutputDto;
    private String comments;
    private String branch;

    public TeacherOutputDto(Teacher teacher) {
        setId_teacher(teacher.getId_teacher());
        setPersonOutputDto(new PersonOutputDto(teacher.getPerson()));
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }
}
