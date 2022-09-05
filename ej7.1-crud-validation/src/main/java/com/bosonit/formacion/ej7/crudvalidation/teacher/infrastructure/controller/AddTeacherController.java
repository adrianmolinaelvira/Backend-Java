package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.input.TeacherInputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher")
    public TeacherOutputDto addTeacher(@RequestBody TeacherInputDto teacherInputDto){
        return teacherService.addTeacher(teacherInputDto);
    }
}
