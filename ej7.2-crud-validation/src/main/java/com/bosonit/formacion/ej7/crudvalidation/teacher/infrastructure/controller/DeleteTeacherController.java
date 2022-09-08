package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTeacherController {

    @Autowired
    TeacherService teacherService;

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable String id){
        return teacherService.deleteTeacher(id);
    }
}
