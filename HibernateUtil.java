package org.example;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil
{
    private static final EntityManagerFactory entity = Persistence.createEntityManagerFactory("StudentPU");

    public static EntityManagerFactory getEntityManagerFactory()
    {
        return entity;
    }
}
