package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.feign.TeacherFeign;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/teacher")
public class FindTeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    public TeacherOutputDto findTeacherById(@PathVariable String id){
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/feign/{id}")
    public TeacherOutputDto findTeacherByIdWithFeign(@PathVariable String id) throws IOException {

        TeacherFeign teacherFeign = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Teacher.class))
                .logLevel(Logger.Level.FULL)
                .target(TeacherFeign.class, "http://localhost:8081");

        return teacherFeign.findById(id);
    }
}
