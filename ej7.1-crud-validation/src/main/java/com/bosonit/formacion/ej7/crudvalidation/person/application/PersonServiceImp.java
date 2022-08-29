package com.bosonit.formacion.ej7.crudvalidation.person.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;


    @Override
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) throws Exception {
        if(newPersonDto.getUser() == null)
            throw new Exception("User field can not be null");
        else if(newPersonDto.getUser().length() > 10 || newPersonDto.getUser().length() < 6)
            throw new Exception("User field length is not between 6 and 10");
        else if(newPersonDto.getPassword() == null)
            throw new Exception("Password can not be null");
        else if(newPersonDto.getName() == null)
            throw new Exception("Name can not be null");
        else if(newPersonDto.getCompany_email() == null)
            throw new Exception("Company email is not null");
        else if(!newPersonDto.getCompany_email().contains("@"))
            throw new Exception("Email format is not correct");
        else if(newPersonDto.getPersonal_email() == null)
            throw new Exception("Company email is not null");
        else if(!newPersonDto.getPersonal_email().contains("@"))
            throw new Exception("Email format is not correct");
        else if(newPersonDto.getCity() == null)
            throw new Exception("City can not be null");
        else if(newPersonDto.getCreated_date() == null)
            throw new Exception("Created date can not be null");
        {
            Person newPerson = newPersonDto.transformIntoPerson();

            personRepository.save(newPerson);

            return new PersonOutputDto();
        }
    }

    @Override
    public PersonOutputDto findPersonById(int id) throws Exception {
        Optional<Person> personOptional = personRepository.findById(id);

        if(personOptional.isEmpty())
            throw new Exception("Person does not exist");

        return new PersonOutputDto().transformPersonIntoPersonOutputDto(personOptional.get());
    }

    @Override
    public PersonOutputDto findPersonByName(String name) throws Exception {
       Optional<Person> personOptional = personRepository.findByName(name);

       if(personOptional.isEmpty())
           throw new Exception("Person does not existe");

       return new PersonOutputDto().transformPersonIntoPersonOutputDto(personOptional.get());

    }

    @Override
    public List<PersonOutputDto> getAllPeople() {
        List<Person> peopleList = personRepository.findAll();

        List<PersonOutputDto> peopleOutputDto = new ArrayList<>();

        for(Person person : peopleList)
            peopleOutputDto.add(new PersonOutputDto().transformPersonIntoPersonOutputDto(person));

        return peopleOutputDto;
    }
}
