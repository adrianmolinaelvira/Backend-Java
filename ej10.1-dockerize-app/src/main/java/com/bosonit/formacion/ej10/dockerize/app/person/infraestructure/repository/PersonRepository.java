package com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.repository;


import com.bosonit.formacion.ej10.dockerize.app.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByUsername(String user);

}
