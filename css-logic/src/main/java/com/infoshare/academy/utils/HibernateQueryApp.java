package com.infoshare.academy.utils;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import com.infoshare.academy.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Stateless
public class HibernateQueryApp {


    public static List<Car> listAvailableCar(LocalDate startDate,LocalDate endDate) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Car.class);
        conf.addAnnotatedClass(Reservation.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Car> dostepne=session.createQuery(
                        " SELECT r.car.id FROM Reservation r WHERE "  +
                        "((startDate>'"+endDate+"')"+
                        "or (endDate<'"+startDate+"')) order by r.car.id ASC").getResultList();

        List<Car> NIEdostepne=session.createQuery(
                " SELECT r.car.id FROM Reservation r WHERE NOT "  +
                        "((startDate>'"+endDate+"')"+
                        "or (endDate<'"+startDate+"')) order by r.car.id ASC").getResultList();


        List<Car> listCar=session.createQuery(
                "SELECT c.id FROM Car c " +
                        "where id NOT IN" +
                        " (SELECT r.car.id FROM Reservation r WHERE NOT "  +
                        "((startDate>'"+endDate+"')"+
                        "or (endDate<'"+startDate+"'))) order by c.id ASC").getResultList();

        System.out.println("************************************");
        System.out.println("r.car.id -- termin dostępny " + dostepne);
        System.out.println("r.car.id -- termin niedostpne " + NIEdostepne);
        System.out.println("car.id dostępne do rezerwacji "+listCar);

        session.getTransaction().commit();
        session.close();



        return listCar;
    }
}
