package com.bosonit.formacion.ej6.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
public class MainController
{
    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    @Autowired
    Perfiles perfiles;

    @GetMapping("/parametros")
    public String getParams(){
        return "url: " + url + "\npassword: " + password;
    }

    @GetMapping("/perfil")
    public String getPerfil(){
        return perfiles.miFuncion();
    }
}
