package com.bosonit.formacion.ej13.mongodb.person.application;

import com.bosonit.formacion.ej13.mongodb.exceptions.EntityNotFoundException;
import com.bosonit.formacion.ej13.mongodb.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej13.mongodb.person.domain.Person;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) {
        newPersonDto.setCreated_date(new Date());

        if(newPersonDto.getUsername() == null)
            throw new UnprocessableEntityException("User field can not be null");
        if(newPersonDto.getUsername().length() > 10 || newPersonDto.getUsername().length() < 6)
            throw new UnprocessableEntityException("User field length is not between 6 and 10");
        if(newPersonDto.getPassword() == null)
            throw new UnprocessableEntityException("Password can not be null");
        if(newPersonDto.getName() == null)
            throw new UnprocessableEntityException("Name can not be null");
        if(newPersonDto.getCompany_email() == null)
            throw new UnprocessableEntityException("Company email is not null");
        if(!newPersonDto.getCompany_email().contains("@"))
            throw new UnprocessableEntityException("Email format is not correct");
        if(newPersonDto.getPersonal_email() == null)
            throw new UnprocessableEntityException("Company email is not null");
        if(!newPersonDto.getPersonal_email().contains("@"))
            throw new UnprocessableEntityException("Email format is not correct");
        if(newPersonDto.getCity() == null)
            throw new UnprocessableEntityException("City can not be null");
        if(newPersonDto.getCreated_date() == null)
            throw new UnprocessableEntityException("Created date can not be null");

        Person newPerson = newPersonDto.transformIntoPerson();

        personRepository.save(newPerson);

        return new PersonOutputDto(newPerson);
    }

    @Override
    public PersonOutputDto updatePerson(String id, PersonInputDto personInputDto) {
        Optional<Person> personOpt = personRepository.findById(id);

        if(personOpt.isEmpty())
            throw new EntityNotFoundException("The person does no exist");
        if(personInputDto.getUsername() == null)
            throw new UnprocessableEntityException("User field can not be null");
        if(personInputDto.getUsername().length() > 10 || personInputDto.getUsername().length() < 6)
            throw new UnprocessableEntityException("User field length is not between 6 and 10");
        if(personInputDto.getPassword() == null)
            throw new UnprocessableEntityException("Password can not be null");
        if(personInputDto.getName() == null)
            throw new UnprocessableEntityException("Name can not be null");
        if(personInputDto.getCompany_email() == null)
            throw new UnprocessableEntityException("Company email is not null");
        if(!personInputDto.getCompany_email().contains("@"))
            throw new UnprocessableEntityException("Email format is not correct");
        if(personInputDto.getPersonal_email() == null)
            throw new UnprocessableEntityException("Company email is not null");
        if(!personInputDto.getPersonal_email().contains("@"))
            throw new UnprocessableEntityException("Email format is not correct");
        if(personInputDto.getCity() == null)
            throw new UnprocessableEntityException("City can not be null");

        Person person = personOpt.get();

        person.setUsername(personInputDto.getUsername());
        person.setPassword(personInputDto.getPassword());
        person.setName(personInputDto.getName());
        person.setSurname(personInputDto.getSurname());
        person.setCompany_email(personInputDto.getCompany_email());
        person.setPersonal_email(personInputDto.getCompany_email());
        person.setCity(personInputDto.getCity());
        person.setActive(personInputDto.getActive());
        person.setImage_url(personInputDto.getImage_url());

        personRepository.save(person);

        return new PersonOutputDto(person);
    }

    @Override
    public PersonOutputDto findPerson(String id) {

        Optional<Person> personOptional = personRepository.findById(id);

        return new PersonOutputDto(personOptional.orElseThrow(() -> new EntityNotFoundException("Person does not exist")));
    }

    @Override
    public List<PersonOutputDto> findPeopleByUsername(String username) {
        List<Person> peopleList = personRepository.findByUsername(username);

        return peopleList.stream().map(PersonOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<PersonOutputDto> getAllPeople(Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page, 10, sort);

        Page<Person> peoplePage = personRepository.findAll(pageable);
        List<PersonOutputDto> personOutputDtoList = peoplePage.stream().map(PersonOutputDto::new).collect(Collectors.toList());

        return new PageImpl<>(personOutputDtoList, pageable, personOutputDtoList.size());
    }

    @Override
    public String deletePerson(String id) {
        Optional<Person> personOptional = personRepository.findById(id);

        Person person = personOptional.orElseThrow(() -> new EntityNotFoundException("Person does not exist"));

        personRepository.delete(person);

        return "The person has been deleted";
    }
}
