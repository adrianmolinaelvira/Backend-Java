package com.bosonit.formacion.ej10.dockerize.app.person.application;


import com.bosonit.formacion.ej10.dockerize.app.person.domain.Person;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.output.PersonOutputDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) throws Exception;

    public PersonOutputDto findPersonById(int id) throws Exception;

    public List<PersonOutputDto> findPersonByUsername(String Name) throws Exception;

    public List<PersonOutputDto> getAllPeople();

    public PersonOutputDto updatePerson(int id, PersonInputDto personInputDto) throws Exception;

    public String deletePerson(int id) throws Exception;

    public Optional<Person> getPersonOptional(int id);
}
