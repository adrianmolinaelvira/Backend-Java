package com.bosonit.formacion.ej7.crudvalidation.teacher.application;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.formacion.ej7.crudvalidation.student.application.StudentService;
import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.repository.StudentRepository;
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
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public TeacherOutputDto addTeacher(TeacherInputDto teacherInputDto) {

        if(teacherInputDto.getId_person() == null)
            throw new UnprocessableEntityException("id_person can not be null", 422);
        if(!teacherInputDto.getBranch().equals("Front") && !teacherInputDto.getBranch().equals("Back") && !teacherInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value", 422);

        //Checks if person exist
        Optional<Person> personOpt = personRepository.findById(teacherInputDto.getId_person());

        if(personOpt.isEmpty())
            throw  new UnprocessableEntityException("The person does not exist", 422);

        Optional<Student> studentOpt = studentRepository.findByPerson(personOpt.get());
        Optional<Teacher> teacherOpt = teacherRepository.findByPerson(personOpt.get());

        if(teacherOpt.isPresent() || studentOpt.isPresent())
            throw new UnprocessableEntityException("The person is already a student or teacher", 422);

        Teacher newTeacher = teacherInputDto.transformIntoTeacher(personOpt.get());

        teacherRepository.save(newTeacher);

        return new TeacherOutputDto(newTeacher);
    }

    @Override
    public TeacherOutputDto updateTeacher(String id, TeacherInputDto teacherInputDto) {

        Optional<Teacher> teacherToUpdateOpt = teacherRepository.findById(id);

        if(teacherToUpdateOpt.isEmpty())
            throw new EntityNotFoundException("The teacher does not exist", 404);

        Teacher teacherToUpdate = teacherToUpdateOpt.get();

        if(teacherInputDto.getId_person() == null)
            throw new UnprocessableEntityException("id_person can not be null", 422);
        if(!teacherInputDto.getBranch().equals("Front") && !teacherInputDto.getBranch().equals("Back") && !teacherInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value", 422);

        //Checks if person exist
        Optional<Person> personOpt = personRepository.findById(teacherInputDto.getId_person());

        if(personOpt.isEmpty())
            throw  new UnprocessableEntityException("The person does not exist", 422);

        Optional<Student> studentOpt = studentRepository.findByPerson(personOpt.get());
        Optional<Teacher> teacherOpt = teacherRepository.findByPerson(personOpt.get());

        //Checks if actual person is different of the actual
        if(teacherInputDto.getId_person() != teacherToUpdate.getPerson().getId_person())
            if(teacherOpt.isPresent() || studentOpt.isPresent())
                throw new UnprocessableEntityException("The person is already a student or teacher", 422);

        //Updates teacher data
        teacherToUpdate.setBranch(teacherInputDto.getBranch());
        teacherToUpdate.setPerson(personOpt.get());
        teacherToUpdate.setComments(teacherInputDto.getComments());

        teacherRepository.save(teacherToUpdate);

        return new TeacherOutputDto(teacherToUpdate);
    }

    @Override
    public TeacherOutputDto findTeacherById(String id) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(id);

        return new TeacherOutputDto(teacherOpt.orElseThrow(() -> new EntityNotFoundException("The teacher does not exist", 404)));
    }

    @Override
    public String deleteTeacher(String id) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(id);

        teacherRepository.delete(teacherOpt.orElseThrow(() -> new EntityNotFoundException("The teacher does not exist", 404)));

        return "The teacher has been deleted";
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
