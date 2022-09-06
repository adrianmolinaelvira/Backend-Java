package com.bosonit.formacion.ej7.crudvalidation.student.application;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.student.domain.Student;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.input.StudentInputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.controller.ouput.StudentOutputDtoWithSubjects;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.repository.StudentRepository;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.domain.StudentSubject;
import com.bosonit.formacion.ej7.crudvalidation.student_subject.infrastructure.repository.StudentSubjectRepository;
import com.bosonit.formacion.ej7.crudvalidation.teacher.application.TeacherService;
import com.bosonit.formacion.ej7.crudvalidation.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonService personService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    @Override
    public StudentOutputDto addStudent(StudentInputDto studentInputDto) {

        if(studentInputDto.getPerson_id() == null)
            throw new UnprocessableEntityException("Person_id can not be null", 422);
        if(studentInputDto.getNum_hours_week() == null)
            throw new UnprocessableEntityException("num_hours_week can not be null", 422);
        if(!studentInputDto.getBranch().equals("Front") && !studentInputDto.getBranch().equals("Back") && !studentInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value", 422);

        //Check if person exists in personService
        Optional<Person> personOpt = personService.getPersonOptional(studentInputDto.getPerson_id());

        if(personOpt.isEmpty())
            throw new EntityNotFoundException("The person does no exist", 404);

        //Checks is person already belongs to a student/teacher
        Optional<Teacher> teacherOpt = teacherService.getTeacherOptionalByPerson(personOpt.get());
        Optional<Student> studentOpt = studentRepository.findByPerson(personOpt.get());

        if(teacherOpt.isPresent() || studentOpt.isPresent())
            throw new UnprocessableEntityException("The person is already a student or teacher", 422);

        teacherOpt = teacherService.getTeacherOptional(studentInputDto.getTeacher_id());

        Student newStudent = studentInputDto.transformIntoStudent(personOpt.get(), teacherOpt.orElse(null));

        studentRepository.save(newStudent);

        return new StudentOutputDto(newStudent);
    }

    @Override
    public StudentOutputDto updateStudent(String id, StudentInputDto studentInputDto) {
        Optional<Student> studentToUpdateOpt = studentRepository.findById(id);

        if(studentToUpdateOpt.isEmpty())
            throw new EntityNotFoundException("Student does not exist", 404);

        Student studentToUpdate = studentToUpdateOpt.get();

        if(studentInputDto.getPerson_id() == null)
            throw new UnprocessableEntityException("Person_id can not be null", 422);
        if(studentInputDto.getNum_hours_week() == null)
            throw new UnprocessableEntityException("num_hours_week can not be null", 422);
        if(!studentInputDto.getBranch().equals("Front") && !studentInputDto.getBranch().equals("Back") && !studentInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch can not be null", 422);

        //Check if person exists in personService
        Optional<Person> personOpt = personService.getPersonOptional(studentInputDto.getPerson_id());

        if(personOpt.isEmpty())
            throw new EntityNotFoundException("The person does no exist", 404);

        //Checks is person already belongs to a student/teacher
        Optional<Teacher> teacherOpt = teacherService.getTeacherOptionalByPerson(personOpt.get());
        Optional<Student> studentOpt = studentRepository.findByPerson(personOpt.get());

        if(studentInputDto.getPerson_id() != studentToUpdate.getPerson().getId_person())
            if(teacherOpt.isPresent() || studentOpt.isPresent())
                throw new UnprocessableEntityException("The person is already a student or teacher", 422);


        teacherOpt = teacherService.getTeacherOptional(studentInputDto.getTeacher_id());

        //Update student params
        studentToUpdate.setPerson(personOpt.get());
        studentToUpdate.setNum_hours_week(studentInputDto.getNum_hours_week());
        studentToUpdate.setComments(studentInputDto.getComments());
        studentToUpdate.setTeacher(teacherOpt.orElse(null));
        studentToUpdate.setBranch(studentInputDto.getBranch());

        studentRepository.save(studentToUpdate);

        return new StudentOutputDto(studentToUpdate);
    }

    @Override
    public StudentOutputDto findStudentById(String id) {
        Optional<Student> studentOpt = studentRepository.findById(id);

        return new StudentOutputDto(studentOpt.orElseThrow(() -> new EntityNotFoundException("The student does not exist", 404)));
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.delete(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The Student does not exist", 404)));

        return "The student has been deleted";
    }

    @Override
    public Optional<Student> getStudentOptional(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> getStudentOptionalByPerson(Person person) {
        return studentRepository.findByPerson(person);
    }

    @Override
    @Transactional
    public StudentOutputDtoWithSubjects addSubjectToStudent(String id_student, String id_subject) {

        Student student = studentRepository.findById(id_student).orElseThrow(() -> new EntityNotFoundException("Student does not exist", 404));
        StudentSubject subject = studentSubjectRepository.findById(id_subject).orElseThrow(() -> new EntityNotFoundException("Subject does not exist", 404));

        if(student.getStudentSubjects().contains(subject))
            throw new UnprocessableEntityException("The student already has this subject", 422);

        subject.getStudents().add(student);
        student.getStudentSubjects().add(subject); //Sin efecto en la base de datos

        studentSubjectRepository.save(subject);

        return new StudentOutputDtoWithSubjects(student);
    }

    @Override
    @Transactional
    public StudentOutputDtoWithSubjects deleteSubjectFromStudent(String id_student, String id_subject) {
        Student student = studentRepository.findById(id_student).orElseThrow(() -> new EntityNotFoundException("Student does not exist", 404));
        StudentSubject subject = studentSubjectRepository.findById(id_subject).orElseThrow(() -> new EntityNotFoundException("Subject does not exist", 404));

        if(!student.getStudentSubjects().contains(subject))
            throw new UnprocessableEntityException("The student don't have this subject", 422);

        subject.getStudents().remove(student);
        student.getStudentSubjects().remove(subject); //Sin efecto en la base de datos

        studentSubjectRepository.save(subject);

        return new StudentOutputDtoWithSubjects(student);
    }
}
