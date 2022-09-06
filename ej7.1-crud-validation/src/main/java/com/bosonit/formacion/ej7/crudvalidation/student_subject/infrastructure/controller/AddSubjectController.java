package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.application.StudentSubjectService;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @PostMapping("/subject")
    public StudentSubjectOutputDto addSubject(@RequestBody StudentSubjectInputDto studentSubjectInputDto){
        return studentSubjectService.addSubject(studentSubjectInputDto);
    }
}
