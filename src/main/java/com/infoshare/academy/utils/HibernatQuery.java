package com.infoshare.academy.utils;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;


@Stateless
public class HibernatQuery {


    public static List<Reservation> listAvailableCar(LocalDate startDate,LocalDate endDate) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Car.class);
        conf.addAnnotatedClass(Reservation.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Reservation> listAvailableCar = session.createQuery("select r from Reservation r " +
                "where" +
                " (startDate>'"+startDate+"' and startDate>'"+endDate+"')" +
                " or (endDate<'"+startDate+"' and startDate>'"+endDate+"' ) " +
                "or (endDate<'"+startDate+"')" ).getResultList();

        session.getTransaction().commit();
        session.close();

        return listAvailableCar;
    }
}
