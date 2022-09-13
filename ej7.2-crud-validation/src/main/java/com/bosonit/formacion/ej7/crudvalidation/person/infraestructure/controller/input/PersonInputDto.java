package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import lombok.Data;

import java.util.Date;
@Data
public class PersonInputDto {

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public Person transformIntoPerson(){
        Person person = new Person();
        person.setUsername(this.usuario);
        person.setPassword(this.password);
        person.setName(this.name);
        person.setSurname(this.surname);
        person.setCompany_email(this.company_email);
        person.setPersonal_email(this.personal_email);
        person.setCity(this.city);
        person.setActive(this.active);
        person.setCreated_date(this.created_date);
        person.setImagen_url(this.imagen_url);
        person.setTermination_date(this.termination_date);

        return person;
    }

    public boolean getActive(){
        return this.active;
    }
}
