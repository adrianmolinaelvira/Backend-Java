package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByUsername(String user);

}
