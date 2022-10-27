package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output;

import com.bosonit.formacion.Backend161.Client.Domain.Client;
import lombok.Data;


@Data
public class OutputClientDto {
    Long id;
    String name;
    String surname;
    Integer age;
    String email;
    Integer phone_number;

    public OutputClientDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.age = client.getAge();
        this.email = client.getEmail();
        this.phone_number = client.getPhone_number();
    }
}