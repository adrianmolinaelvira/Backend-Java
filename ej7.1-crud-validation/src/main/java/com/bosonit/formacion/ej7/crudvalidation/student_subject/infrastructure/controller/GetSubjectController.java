package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.application.StudentSubjectService;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class GetSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @GetMapping("/{id}")
    public StudentSubjectOutputDto getSubjectById(@PathVariable String id){
        return  studentSubjectService.findSubjectById(id);
    }
}
