package com.bosonit.formacion.ej13.mongodb.person.application;

import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto personInputDto);

    PersonOutputDto updatePerson(String id, PersonInputDto personInputDto);

    PersonOutputDto findPerson(String id);

    List<PersonOutputDto> findPeopleByUsername(String username);

    Page<PersonOutputDto> getAllPeople(Integer page);

    String deletePerson(String id);
}
