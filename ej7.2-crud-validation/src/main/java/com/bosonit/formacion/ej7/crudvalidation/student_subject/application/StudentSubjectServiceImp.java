package com.bosonit.formacion.ej7.crudvalidation.student_subject.application;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.repository.StudentRepository;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.input.StudentSubjectInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.controller.ouput.StudentSubjectOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.repository.StudentSubjectRepository;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentSubjectServiceImp implements StudentSubjectService {

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public StudentSubjectOutputDto addSubject(StudentSubjectInputDto studentSubjectInputDto) {

        if(studentSubjectInputDto.getId_teacher() == null)
            throw new UnprocessableEntityException("id_teacher can not be null", 422);
        if(studentSubjectInputDto.getSubject().isBlank())
            throw new UnprocessableEntityException("subject can not be null or blank", 422);
        if(studentSubjectInputDto.getInitial_date() == null)
            throw new UnprocessableEntityException("Initial date can not be null", 422);

        Optional<Teacher> teacherOptional = teacherRepository.findById(studentSubjectInputDto.getId_teacher());

        if(teacherOptional.isEmpty())
            throw new UnprocessableEntityException("The teacher does not exist", 422);

        StudentSubject newSubject = studentSubjectInputDto.transformIntoStudentSubject(teacherOptional.get());

        studentSubjectRepository.save(newSubject);

        return new StudentSubjectOutputDto(newSubject);
    }

    @Override
    public StudentSubjectOutputDto updateSubject(String id, StudentSubjectInputDto studentSubjectInputDto) {

        StudentSubject studentSubjectToUpdate = studentSubjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject does not exist", 404));

        if(studentSubjectInputDto.getId_teacher() == null)
            throw new UnprocessableEntityException("id_teacher can not be null", 422);
        if(studentSubjectInputDto.getSubject().isBlank())
            throw new UnprocessableEntityException("subject can not be null or blank", 422);
        if(studentSubjectInputDto.getInitial_date() == null)
            throw new UnprocessableEntityException("Initial date can not be null", 422);

        Teacher teacher = teacherRepository.findById(studentSubjectInputDto.getId_teacher()).orElseThrow(() -> new EntityNotFoundException("The teacher does not exist", 404));

        studentSubjectToUpdate.setSubject(studentSubjectInputDto.getSubject());
        studentSubjectToUpdate.setTeacher(teacher);
        studentSubjectToUpdate.setComments(studentSubjectInputDto.getComments());
        studentSubjectToUpdate.setInitial_date(studentSubjectInputDto.getInitial_date());
        studentSubjectToUpdate.setFinish_date(studentSubjectInputDto.getFinish_date());

        studentSubjectRepository.save(studentSubjectToUpdate);

        return new StudentSubjectOutputDto(studentSubjectToUpdate);
    }

    @Override
    public StudentSubjectOutputDto findSubjectById(String id) {
        return new StudentSubjectOutputDto(studentSubjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject does not exist", 404)));
    }

    @Override
    public String deleteSubject(String id) {

        StudentSubject subject = studentSubjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject does not exist", 404));

        if(subject.getStudents().size() != 0)
            throw new UnprocessableEntityException("The subject has students", 422);

        studentSubjectRepository.delete(subject);

        return "The subject has been deleted";
    }
}
