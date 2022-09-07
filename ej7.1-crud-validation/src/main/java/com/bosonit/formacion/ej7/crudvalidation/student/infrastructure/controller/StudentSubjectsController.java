package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDtoWithSubjects;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentSubjectsController {

    @Autowired
    StudentService studentService;

    @PutMapping("/student/{id_student}/subjects")
    public String addSubjectToStudent(@PathVariable String id_student, @RequestBody List<String> subjectsIds){
        return studentService.addSubjectToStudent(id_student, subjectsIds);
    }

    @DeleteMapping("/student/{id_student}/subjects")
    public String deleteSubjectFromStudent(@PathVariable String id_student, @RequestBody List<String> subjectsIds){
        return studentService.deleteSubjectFromStudent(id_student, subjectsIds);
    }
}
