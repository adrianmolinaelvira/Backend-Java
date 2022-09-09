package com.bosonit.formacion.ej5.profiles20.Profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@org.springframework.context.annotation.Profile("local")
@PropertySource("classpath:local.properties")
@Service
public class Local implements Profile{
    @Value("${environment}")
    String environment;

    @Value("${bd.url}")
    String bdURL;

    @Override
    public void readProperties() {
        System.out.println(environment);
        System.out.println(bdURL);
    }
}
