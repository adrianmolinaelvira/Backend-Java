package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDto {
    private String user;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonOutputDto transformPersonIntoPersonOutputDto(Person person){
        this.user = person.getUser();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this.personal_email= person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.imagen_url = person.getImagen_url();
        this.termination_date = getTermination_date();

        return this;
    }
}


