package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, String> {

    List<StudentSubject> findByTeacher(Teacher teacher);

}
