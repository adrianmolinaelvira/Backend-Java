package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class FindTeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    public TeacherOutputDto findTeacherById(@PathVariable String id){
        return teacherService.findTeacherById(id);
    }
}
