package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
