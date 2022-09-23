package com.bosonit.formacion.ej13.mongodb.person.infraestructure.controller.output;

import com.bosonit.formacion.ej13.mongodb.person.domain.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDto {
    private String id;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public PersonOutputDto(Person person){
        this.id = person.getId();
        this.usuario = person.getUsername();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this.personal_email= person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.image_url = person.getImage_url();
        this.termination_date = person.getTermination_date();
    }
}
