package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
