package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.input.TeacherInputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCreateController {

    @Autowired
    TeacherService teacherService;

    @PutMapping("/teacher/{id}")
    public TeacherOutputDto updateTeacher(@PathVariable String id, @RequestBody TeacherInputDto teacherInputDto){
        return teacherService.updateTeacher(id, teacherInputDto);
    }
}
