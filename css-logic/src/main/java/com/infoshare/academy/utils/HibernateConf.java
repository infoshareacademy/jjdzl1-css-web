package com.infoshare.academy.utils;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConf {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            Configuration conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            conf.addAnnotatedClass(User.class);
            conf.addAnnotatedClass(Car.class);
            conf.addAnnotatedClass(Reservation.class);
            SessionFactory sessionFactory = conf.buildSessionFactory();
            return sessionFactory;
        } catch (Throwable e){
            System.err.println("[Hibernate] Initial SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
