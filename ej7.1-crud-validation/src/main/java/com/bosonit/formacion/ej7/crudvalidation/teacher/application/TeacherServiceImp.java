package com.bosonit.formacion.ej7.crudvalidation.teacher.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    @Override
    public Optional<Teacher> getTeacherOptionalByPerson(Person person) {
        return Optional.empty();
    }

    @Override
    public Optional<Teacher> getTeacherOptional(String id) {
        return Optional.empty();
    }
}
