package com.bosonit.formacion.ej13.mongodb.person.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Person {

    @Id
    private String id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private Date termination_date;
    private String image_url;
}
