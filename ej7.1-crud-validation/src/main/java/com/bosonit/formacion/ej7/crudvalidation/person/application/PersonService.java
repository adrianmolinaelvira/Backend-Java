package com.bosonit.formacion.ej7.crudvalidation.person.application;

import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;

import java.util.List;

public interface PersonService {
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) throws Exception;

    public PersonOutputDto findPersonById(int id) throws Exception;

    public PersonOutputDto findPersonByUsername(String Name) throws Exception;

    public List<PersonOutputDto> getAllPeople();
}
