package com.infoshare.academy.utils;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConf {

    private static SessionFactory sessionFactory = sessionFactory();

    public static SessionFactory sessionFactory() {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Car.class);
        conf.addAnnotatedClass(Reservation.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        return sessionFactory;
    }

    public static synchronized SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
