package com.bosonit.formacion.ej7.crudvalidation.teacher.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;

import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> getTeacherOptionalByPerson(Person person);

    Optional<Teacher> getTeacherOptional(String id);
}
