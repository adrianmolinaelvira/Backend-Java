package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.input;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import lombok.Data;

@Data
public class StudentInputDto {

    private Integer person_id;
    private Integer num_hours_week;
    private String comments;
    private String teacher_id;
    private String branch;

    public Student transformIntoStudent(Person person, Teacher teacher){
        Student student = new Student();

        student.setPerson(person);
        student.setNum_hours_week(this.num_hours_week);
        student.setTeacher(teacher);
        student.setBranch(this.branch);
        student.setComments(this.comments);

        return student;
    }
}
