package com.bosonit.formation.Ejercicio52;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class City {
    String name;
    int NumOfInhabitants;

}
