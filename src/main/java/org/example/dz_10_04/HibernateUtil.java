package org.example.dz_10_04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private  static SessionFactory sessionFactory;
    private HibernateUtil(){}
    public static Session getSession() {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        return factory.openSession();
    }
}
