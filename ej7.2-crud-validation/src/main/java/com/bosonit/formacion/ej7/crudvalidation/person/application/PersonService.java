package com.bosonit.formacion.ej7.crudvalidation.person.application;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonPage;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonSearchCriteria;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDtoWithRoleDetails;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    public PersonOutputDto addPerson(PersonInputDto newPersonDto) throws Exception;

    public PersonOutputDtoWithRoleDetails findPersonById(int id) throws Exception;

    public List<PersonOutputDto> findPersonByUsername(String Name) throws Exception;

    public List<PersonOutputDto> getAllPeople();

    public PersonOutputDto updatePerson(int id, PersonInputDto personInputDto) throws Exception;

    public String deletePerson(int id) throws Exception;

    public Optional<Person> getPersonOptional(int id);

    public Page<PersonOutputDto> getData(PersonPage page, PersonSearchCriteria personSearchCriteria);
}
