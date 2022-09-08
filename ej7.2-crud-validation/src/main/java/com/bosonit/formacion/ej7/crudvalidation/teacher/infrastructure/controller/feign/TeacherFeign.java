package com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.feign;

import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import feign.Param;
import feign.RequestLine;

public interface TeacherFeign {

    @RequestLine("GET /teacher/{id}")
    TeacherOutputDto findById(@Param("id") String id);
}
