package com.bosonit.formacion.ej7.crudvalidation.student.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.input.StudentInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDtoWithSubjects;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public StudentOutputDto addStudent(StudentInputDto studentInputDto);

    public StudentOutputDto updateStudent(String id, StudentInputDto studentInputDto);

    public StudentOutputDto findStudentById(String id);

    public String deleteStudent(String id);

    public Optional<Student> getStudentOptional(String id);

    public Optional<Student> getStudentOptionalByPerson(Person person);

    public String addSubjectToStudent(String id_student, List<String> subjectsIds);

    public String deleteSubjectFromStudent(String id_student, List<String> subjectsIds);
}
