package com.bosonit.formacion.ej7.crudvalidation.student.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.input.StudentInputDto;

import java.util.Optional;

public interface StudentService {

    public StudentOutputDto addStudent(StudentInputDto studentInputDto);

    public StudentOutputDto updateStudent(String id, StudentInputDto studentInputDto);

    public StudentOutputDto findStudentById(String id);

    public String deleteStudent(String id);

    public Optional<Student> getStudentOptional(String id);

    public Optional<Student> getStudentOptionalByPerson(Person person);
}
