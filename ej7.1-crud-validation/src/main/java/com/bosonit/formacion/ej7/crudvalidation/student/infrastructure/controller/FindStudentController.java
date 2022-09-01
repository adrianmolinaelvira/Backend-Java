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
    public StudentOutputDto getStudent(@PathVariable String id, @RequestParam String outputType){

        StudentOutputDto studentOutputDto = studentService.findStudentById(id);

        if(outputType.equals("full"))
            return studentOutputDto;

        studentOutputDto.setPersonOutputDto(null);

        return  studentOutputDto;
    }
}