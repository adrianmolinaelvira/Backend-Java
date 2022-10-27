package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input;


import lombok.Data;

@Data
public class InputClientDto {
    String name;
    String surname;
    Integer age;
    String email;
    Integer phone_number;
}
