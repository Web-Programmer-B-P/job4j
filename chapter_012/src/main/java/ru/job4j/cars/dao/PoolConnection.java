package ru.job4j.cars.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.cars.models.Car;
import ru.job4j.cars.models.Driver;
import ru.job4j.cars.models.Engine;

public class PoolConnection {
    private static final Logger LOG = LogManager.getLogger(PoolConnection.class.getName());
    private static SessionFactory sessionFactory = null;

    static {
        try {
            loadSessionFactory();
        } catch (Exception e) {
            LOG.info("Exception while initializing hibernate util.. ");
            LOG.error("Ошибка загрузки фактори", e);
        }
    }

    public static void loadSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Engine.class);
        configuration.addAnnotatedClass(Driver.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.configure("/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() throws HibernateException {
        Session retSession = null;
        try {
            retSession = sessionFactory.openSession();
        } catch (Throwable t) {
            LOG.error("Exception while getting session..", t);
        }
        if (retSession == null) {
            LOG.error("session is discovered null");
        }
        return retSession;
    }
}
