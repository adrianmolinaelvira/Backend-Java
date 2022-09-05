package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.input;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;

@Data
public class TeacherInputDto {

    private Integer id_person;
    private String comments;
    private String branch;

    public Teacher transformIntoTeacher(Person person){
        Teacher newTeacher = new Teacher();

        newTeacher.setPerson(person);
        newTeacher.setComments(this.comments);
        newTeacher.setBranch(this.branch);

        return newTeacher;
    }
}
