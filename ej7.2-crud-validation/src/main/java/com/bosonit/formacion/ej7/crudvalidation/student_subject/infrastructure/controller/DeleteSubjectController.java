package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.application.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @DeleteMapping("/subject/{id}")
    public String deleteSubject(@PathVariable String id){
        return studentSubjectService.deleteSubject(id);
    }
}
