package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @AfterEach
    void tearDown(){
        personRepository.deleteAll();
    }

    @Test
    void itShouldFindByUsername() {
        //given
        Person person = new PersonInputDto("adrimo100", "12345", "Adrián", "Molina",
                "adrian@company.com", "adrian@personal.com", "Guadalajara",
                true, new Date(), null, null, false).transformIntoPerson();

        personRepository.save(person);

        //when
        List<Person> peopleList = personRepository.findByUsername("adrimo100");

        //then
        assertThat(peopleList.size()).isEqualTo(1);
    }

    @Test
    void itShouldNotFindAnyByUsername() {
        //given

        //when
        List<Person> peopleList = personRepository.findByUsername("adrimo100");

        //then
        assertThat(peopleList.size()).isEqualTo(0);
    }
}