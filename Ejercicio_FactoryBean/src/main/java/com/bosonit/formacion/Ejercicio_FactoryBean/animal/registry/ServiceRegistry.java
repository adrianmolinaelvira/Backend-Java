package com.bosonit.formacion.Ejercicio_FactoryBean.animal.registry;

import com.bosonit.formacion.Ejercicio_FactoryBean.animal.domain.Animal;

public interface ServiceRegistry {
    public <T> AnimalService<T> getAnimal(String name);
}
