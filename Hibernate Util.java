package org.example;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util
{
    private static final EntityManagerFactory entity = Persistence.createEntityManagerFactory("StudentPU");

    public static EntityManagerFactory getEntityManagerFactory()
    {
        return entity;
    }
}
