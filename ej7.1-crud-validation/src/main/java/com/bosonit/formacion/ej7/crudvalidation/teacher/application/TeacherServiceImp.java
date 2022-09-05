package com.bosonit.formacion.ej7.crudvalidation.teacher.application;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.input.TeacherInputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.controller.ouput.TeacherOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PersonService personService;

    @Autowired
    StudentService studentService;

    @Override
    public TeacherOutputDto addTeacher(TeacherInputDto teacherInputDto) {

        if(teacherInputDto.getId_person() == null)
            throw new UnprocessableEntityException("id_person can not be null", 422);
        if(!teacherInputDto.getBranch().equals("Front") && !teacherInputDto.getBranch().equals("Back") && !teacherInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value", 422);

        //Checks if person exist
        Optional<Person> personOpt = personService.getPersonOptional(teacherInputDto.getId_person());

        if(personOpt.isEmpty())
            throw  new UnprocessableEntityException("The person does not exist", 422);

        Optional<Student> studentOpt = studentService.getStudentOptionalByPerson(personOpt.get());
        Optional<Teacher> teacherOpt = teacherRepository.findByPerson(personOpt.get());

        if(teacherOpt.isPresent() || studentOpt.isPresent())
            throw new UnprocessableEntityException("The person is already a student or teacher", 422);

        Teacher newTeacher = teacherInputDto.transformIntoTeacher(personOpt.get());

        teacherRepository.save(newTeacher);

        return new TeacherOutputDto(newTeacher);
    }

    @Override
    public TeacherOutputDto updateTeacher(TeacherInputDto teacherInputDto) {
        return null;
    }

    @Override
    public TeacherOutputDto findTeacherById(String id) {
        return null;
    }

    @Override
    public String deleteTeacher(String id) {
        return null;
    }

    @Override
    public Optional<Teacher> getTeacherOptionalByPerson(Person person) {
        return teacherRepository.findByPerson(person);
    }

    @Override
    public Optional<Teacher> getTeacherOptional(String id) {
        return teacherRepository.findById(id);
    }
}
