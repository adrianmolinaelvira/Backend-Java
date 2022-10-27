package com.bosonit.formacion.BackendFrontend161.Client.Domain;


import com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.BackendFrontend161.Travel.Domain.Travel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    Long id;
    String name;
    String surname;
    Integer age;
    String email;
    Integer phone_number;
    Travel travel;

    public Client(InputClientDto inputClientDto){
        this.name = inputClientDto.getName();
        this.surname = inputClientDto.getSurname();
        this.age = inputClientDto.getAge();
        this.email = inputClientDto.getEmail();
        this.phone_number = inputClientDto.getPhone_number();
    }
}

