package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class ReservationRepositoryDaoBean implements ReservationRepositoryDao {


    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        Session session = getSession();
        session.save(reservation);
        session.getTransaction().commit();
        session.close();
        return reservation;
    }

    @Override
    public List<Reservation> list() {
        Session session = getSession();
        List<Reservation> reservationList = session.createQuery
                ("select r from Reservation r")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationList;
    }

    public List<Reservation> getReservationListByUserId(Integer id) {
        Session session = getSession();
        List<Reservation> reservationListByUserId = session.createQuery
                ("select r from Reservation r where user='" + id + "'")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationListByUserId;
    }


    @Override
    public Reservation updateReservation(Integer id, Car car, LocalDate startDate, LocalDate endDate) {
        Session session = getSession();
        Reservation updateReservation = session.get(Reservation.class, id);
        updateReservation.setCar(car);
        updateReservation.setStartDate(startDate);
        updateReservation.setEndDate(endDate);
        session.close();
        return updateReservation;
    }

    @Override
    public void deleteReservation(Integer id) {
        Session session = getSession();
        Reservation reservationToDelete = session.get(Reservation.class, id);
        session.delete(reservationToDelete);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Reservation> getReservationListAvailableCar(LocalDate startDate, LocalDate endDate) {
        Session session =getSession();
        List<Reservation> reservationListAvailableCar = session.createQuery("select r from Reservation r " +
                "where" +
                " (startDate>'"+startDate+"' and startDate>'"+endDate+"')" +
                " or (endDate<'"+startDate+"' and startDate>'"+endDate+"' ) " +
                "or (endDate<'"+startDate+"')" ).getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationListAvailableCar;

    }

    @Override
    public Stream<Reservation> searchReservation(Filter filter) {
        return null;
    }
}


