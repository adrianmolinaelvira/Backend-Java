package com.bosonit.formacion.ej6.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("perfil1")
@Component
public class Perfil1 implements Perfiles{
    @Override
    public String miFuncion(){
        return "Soy el perfil1";
    }
}
