package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDtoWithSubjects;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PersonOutputDtoWithRoleDetails {
    private int person_id;
    private String user;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    private TeacherOutputDto teacherData;

    private List<StudentOutputDtoWithSubjects> students;

    private StudentOutputDtoWithSubjects studentData;

    public PersonOutputDtoWithRoleDetails(Person person, Teacher teacher,List<Student> studentsList,Student student) {
        this.person_id = person.getId_person();
        this.user = person.getUsername();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this.personal_email = person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.imagen_url = person.getImagen_url();
        this.termination_date = person.getTermination_date();

        if (teacher != null) {
            setTeacherData(new TeacherOutputDto(teacher));

            List<StudentOutputDtoWithSubjects> studentOutputList = studentsList.stream()
                    .map(StudentOutputDtoWithSubjects::new).collect(Collectors.toList());
            setStudents(studentOutputList);
        } else if (student != null) {
            setStudentData(new StudentOutputDtoWithSubjects(student));
            setStudents(null);
        }
    }
}


