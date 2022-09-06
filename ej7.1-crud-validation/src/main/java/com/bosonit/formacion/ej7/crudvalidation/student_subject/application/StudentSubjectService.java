package com.bosonit.formacion.ej7.crudvalidation.student_subject.application;

import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;

public interface StudentSubjectService {

    public StudentSubjectOutputDto addSubject(StudentSubjectInputDto studentSubjectInputDto);

    public StudentSubjectOutputDto updateSubject(String id, StudentSubjectInputDto studentSubjectInputDto);

    public StudentSubjectOutputDto findSubjectById(String id);

    public String deleteSubject(String id);
}
