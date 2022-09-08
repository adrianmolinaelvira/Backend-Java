package com.bosonit.formacion.ej6.pathvariableheaders;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    String name, city;
    int age;

    @Override
    public String toString(){
        return "{\nnombre: " + this.getName() + ",\nciudad: "  + this.getCity() + ",\nedad: " + this.getAge() +"\n}";
    }
}
