package com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.Output;

import com.bosonit.formacion.BackendFrontend161.Client.Domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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