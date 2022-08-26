package com.bosonit.formacion.ej6.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("perfil2")
@Component
public class Perfil2 implements Perfiles{
    @Override
    public String miFuncion(){
        return "Soy el perfil2";
    }
}
