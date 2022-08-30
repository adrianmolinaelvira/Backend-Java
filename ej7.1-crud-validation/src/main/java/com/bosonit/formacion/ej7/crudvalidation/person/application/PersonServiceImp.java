package com.bosonit.formacion.ej7.crudvalidation.person.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) throws Exception {
        newPersonDto.setCreated_date(new Date());

        if(newPersonDto.getUser() == null)
            throw new Exception("User field can not be null");
        if(newPersonDto.getUser().length() > 10 || newPersonDto.getUser().length() < 6)
            throw new Exception("User field length is not between 6 and 10");
        if(newPersonDto.getPassword() == null)
            throw new Exception("Password can not be null");
        if(newPersonDto.getName() == null)
            throw new Exception("Name can not be null");
        if(newPersonDto.getCompany_email() == null)
            throw new Exception("Company email is not null");
        if(!newPersonDto.getCompany_email().contains("@"))
            throw new Exception("Email format is not correct");
        if(newPersonDto.getPersonal_email() == null)
            throw new Exception("Company email is not null");
       if(!newPersonDto.getPersonal_email().contains("@"))
            throw new Exception("Email format is not correct");
        if(newPersonDto.getCity() == null)
            throw new Exception("City can not be null");
        if(newPersonDto.getCreated_date() == null)
            throw new Exception("Created date can not be null");

        Person newPerson = newPersonDto.transformIntoPerson();

            System.out.println(newPersonDto);
            System.out.println(newPerson);

            personRepository.save(newPerson);

            return new PersonOutputDto().transformPersonIntoPersonOutputDto(newPerson);
    }

    @Override
    public PersonOutputDto findPersonById(int id) throws Exception {
        Optional<Person> personOptional = personRepository.findById(id);

        if(personOptional.isEmpty())
            throw new Exception("Person does not exist");

        return new PersonOutputDto().transformPersonIntoPersonOutputDto(personOptional.get());
    }

    @Override
    public PersonOutputDto findPersonByUsername(String username) throws Exception {
       Optional<Person> personOptional = personRepository.findByUsername(username);

       if(personOptional.isEmpty())
           throw new Exception("Person does not exist");

       return new PersonOutputDto().transformPersonIntoPersonOutputDto(personOptional.get());

    }

    @Override
    public List<PersonOutputDto> getAllPeople() {
        List<Person> peopleList = personRepository.findAll();

        List<PersonOutputDto> peopleOutputDto = new ArrayList<>();

        /*for(Person person : peopleList)
            peopleOutputDto.add(new PersonOutputDto().transformPersonIntoPersonOutputDto(person));*/

        peopleOutputDto = peopleList.stream().map(person -> new PersonOutputDto().transformPersonIntoPersonOutputDto(person)).collect(Collectors.toList());

        return peopleOutputDto;
    }

    @Override
    public PersonOutputDto updatePerson(int id, PersonInputDto personInputDto) throws Exception {

        Optional<Person> personOpt = personRepository.findById(id);

        if(personOpt.isEmpty())
            throw new Exception("The person does no exist");

        Person person = personOpt.get();

        person.setUsername(personInputDto.getUser());
        person.setPassword(personInputDto.getPassword());
        person.setName(personInputDto.getName());
        person.setSurname(personInputDto.getSurname());
        person.setCompany_email(personInputDto.getCompany_email());
        person.setPersonal_email(personInputDto.getCompany_email());
        person.setCity(personInputDto.getCity());
        person.setActive(personInputDto.getActive());
        person.setImagen_url(personInputDto.getImagen_url());

        personRepository.save(person);

        return new PersonOutputDto().transformPersonIntoPersonOutputDto(person);
    }

    @Override
    public String deletePerson(int id) throws Exception {

        Optional<Person> personOpt = personRepository.findById(id);

        if(personOpt.isEmpty())
            throw new Exception("The person does no exist");

        personRepository.delete(personOpt.get());

        return "La persona ha sido borrada con éxito";
    }
}
