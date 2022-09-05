package com.bosonit.formacion.ej7.crudvalidation.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.exception.spi.Configurable;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Properties;

public class StringIdGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        long total = session.createQuery(query).list().size();

        return prefix + "-" + (total + 1);
    }

    @Override
    public void configure(Properties properties) throws HibernateException {
        prefix = properties.getProperty("prefix");
    }
}
