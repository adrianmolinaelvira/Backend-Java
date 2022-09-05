package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Optional<Teacher> findByPerson(Person person);

}
