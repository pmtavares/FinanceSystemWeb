package com.finance.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.finance.domain.Person;
import com.finance.domain.State;

public class HibernateUtil {
	
	/*
	private static SessionFactory sessionFactory;
    
	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/financialdb");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL94Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                configuration.setProperties(settings);
                //configuration.addAnnotatedClass(State.class);
                //configuration.addAnnotatedClass(Person.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    } */
	
	private static SessionFactory sessionFactory = createSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory()
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try
		{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			return sessionFactory;
		}
		catch(Throwable ex)
		{
			StandardServiceRegistryBuilder.destroy(registry);
			System.err.println("The connection could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	} 
	
	
}
