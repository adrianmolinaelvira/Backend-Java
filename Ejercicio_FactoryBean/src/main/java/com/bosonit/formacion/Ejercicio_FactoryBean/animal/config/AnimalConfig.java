package com.bosonit.formacion.Ejercicio_FactoryBean.animal.config;


import com.bosonit.formacion.Ejercicio_FactoryBean.animal.registry.ServiceRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AnimalConfig {

    @Bean
    public FactoryBean<?> factoryBean(){
        final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(ServiceRegistry.class);
        return bean;
    }
}
