package com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class FindStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public StudentOutputDto getStudent(@PathVariable String id, @RequestParam(required = false) String outputType){

        StudentOutputDto studentOutputDto = studentService.findStudentById(id);

        if(outputType == null)
            outputType = "simple";

        if(outputType.equals("full"))
            return studentOutputDto;

        studentOutputDto.setPerson(null);

        return  studentOutputDto;
    }
}