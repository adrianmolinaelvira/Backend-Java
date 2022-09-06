package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDtoWithSubjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentSubjectsController {

    @Autowired
    StudentService studentService;

    @PutMapping("/student/{id_student}/{id_subject}")
    public StudentOutputDtoWithSubjects addSubjectToStudent(@PathVariable String id_student, @PathVariable String id_subject){
        return studentService.addSubjectToStudent(id_student, id_subject);
    }

    @DeleteMapping("/student/{id_student}/{id_subject}")
    public StudentOutputDtoWithSubjects deleteSubjectFromStudent(@PathVariable String id_student, @PathVariable String id_subject){
        return studentService.deleteSubjectFromStudent(id_student, id_subject);
    }
}
