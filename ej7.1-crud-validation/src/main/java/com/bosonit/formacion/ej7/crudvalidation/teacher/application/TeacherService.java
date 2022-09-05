package com.bosonit.formacion.ej7.crudvalidation.teacher.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.input.TeacherInputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;

import java.util.Optional;

public interface TeacherService {

    TeacherOutputDto addTeacher(TeacherInputDto teacherInputDto);

    TeacherOutputDto updateTeacher(String id, TeacherInputDto teacherInputDto);

    TeacherOutputDto findTeacherById(String id);

    String deleteTeacher(String id);

    Optional<Teacher> getTeacherOptionalByPerson(Person person);

    Optional<Teacher> getTeacherOptional(String id);
}
