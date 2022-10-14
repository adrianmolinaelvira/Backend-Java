package com.bosonit.formacion.Ejercicio_FactoryBean;

import com.bosonit.formacion.Ejercicio_FactoryBean.animal.domain.Animal;
import com.bosonit.formacion.Ejercicio_FactoryBean.animal.registry.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

    @Autowired
    private ServiceRegistry serviceRegistry;

    @PostMapping("/animal")
    public String proccessAnimal(@RequestBody Animal animal){
        try{
            return serviceRegistry.getAnimal(animal.getType()).getName();
        }
        catch (Exception e){
            throw new RuntimeException("This animal does not exist");
        }
    }
}
