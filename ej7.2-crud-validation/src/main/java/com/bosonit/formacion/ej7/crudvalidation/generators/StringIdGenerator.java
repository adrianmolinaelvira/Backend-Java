package com.bosonit.formacion.ej7.crudvalidation.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;


import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

public class StringIdGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query).stream();

        Long max = ids.map(o -> o.replace(obj.getClass().getSimpleName().toLowerCase() + "-", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return obj.getClass().getSimpleName().toLowerCase() + "-" + (max + 1);


        /*String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        long total = session.createQuery(query).list().size();

        return obj.getClass().getSimpleName().toLowerCase() + "-" + (total + 1);*/

    }
}
