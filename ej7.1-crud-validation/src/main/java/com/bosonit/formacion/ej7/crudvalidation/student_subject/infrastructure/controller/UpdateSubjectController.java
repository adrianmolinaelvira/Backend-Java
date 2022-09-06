package com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.application.StudentSubjectService;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @PutMapping("/subject/{id}")
    public StudentSubjectOutputDto updateSubject(@PathVariable String id, @RequestBody StudentSubjectInputDto studentSubjectInputDto){
        return studentSubjectService.updateSubject(id, studentSubjectInputDto);
    }
}
