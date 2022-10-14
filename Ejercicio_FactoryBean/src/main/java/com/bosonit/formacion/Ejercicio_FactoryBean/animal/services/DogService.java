package com.bosonit.formacion.Ejercicio_FactoryBean.animal.services;

import com.bosonit.formacion.Ejercicio_FactoryBean.animal.domain.Animal;
import com.bosonit.formacion.Ejercicio_FactoryBean.animal.registry.AnimalService;
import org.springframework.stereotype.Service;

@Service("Dog")
public class DogService implements AnimalService<Animal> {
    @Override
    public String getName() {
        return "This animal is a Dog";
    }
}
