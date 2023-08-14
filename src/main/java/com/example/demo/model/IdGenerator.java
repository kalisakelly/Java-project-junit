package com.example.demo.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class IdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "AA";
    private static long counter = 2;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return PREFIX + counter++;
    }
}
