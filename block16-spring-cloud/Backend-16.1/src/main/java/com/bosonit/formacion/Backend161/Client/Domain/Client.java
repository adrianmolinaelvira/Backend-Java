package com.bosonit.formacion.Backend161.Client.Domain;


import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.Backend161.Travel.Domain.Travel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue()
    Long id;
    String name;
    String surname;
    Integer age;
    String email;
    Integer phone_number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="travel_id")
    @JsonBackReference
    Travel travel;

    public Client(InputClientDto inputClientDto){
        this.name = inputClientDto.getName();
        this.surname = inputClientDto.getSurname();
        this.age = inputClientDto.getAge();
        this.email = inputClientDto.getEmail();
        this.phone_number = inputClientDto.getPhone_number();
    }
}

