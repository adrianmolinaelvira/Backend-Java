package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
}
